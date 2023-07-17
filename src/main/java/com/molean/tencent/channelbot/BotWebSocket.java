package com.molean.tencent.channelbot;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.Timer;
import java.util.TimerTask;

public class BotWebSocket {

    @Getter
    @Setter
    private WebSocket webSocket;
    private final Gson gson;

    private final Bot bot;

    private TimerTask heartbeatTask;
    private final Timer timer = new Timer();

    @Getter
    @Setter
    private long lastHeartbeatACK;
    private final HttpClient httpClient;
    private final URI wssUri;


    public BotWebSocket(Gson gson, Bot bot, HttpClient httpClient) {
        this.gson = gson;
        try {
            this.wssUri = bot.getApiAccess().getWSSUrI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.bot = bot;
        this.httpClient = httpClient;
    }


    public void reconnect(boolean force) {
        if (force) {
            bot.setSession(null);
        }
        if (this.webSocket != null) {
            webSocket.abort();
        }
        this.webSocket = null;
        httpClient.newWebSocketBuilder().buildAsync(wssUri, bot.getBotWebSocketListener()).join();
    }


    public void sendPayload(Payload<?> payload) {
        String data = gson.toJson(payload);
        bot.getBotAccess().getLogger().info("Send payload: " + payload);
        webSocket.sendText(data, true);
    }

    public void startHeartbeat(int heartbeatInterval) {
        if (this.heartbeatTask != null) {
            stopHeartbeat();
        }
        lastHeartbeatACK = System.currentTimeMillis();
        heartbeatTask = new TimerTask() {
            @Override
            public void run() {
                if (bot.isDestroyed()) {
                    return;
                }
                if (System.currentTimeMillis() - lastHeartbeatACK > heartbeatInterval * 2L) {
                    lastHeartbeatACK = System.currentTimeMillis();
                    reconnect(true);
                    return;
                }
                Payload<Integer> heartbeatPayload = new Payload<>();
                heartbeatPayload.setOp(1);
                heartbeatPayload.setD(bot.getBotWebSocketListener().getSequence());
                bot.getBotWebSocket().sendPayload(heartbeatPayload);
                bot.getBotAccess().getLogger().info("Send heartbeat packet.");
            }
        };
        timer.scheduleAtFixedRate(heartbeatTask, heartbeatInterval, heartbeatInterval);
    }

    public void stopHeartbeat() {
        if (heartbeatTask != null) {
            try {
                heartbeatTask.cancel();
            } catch (Exception ignored) {
            }
        }
        heartbeatTask = null;
    }

    public void abort() {
        stopHeartbeat();
        webSocket.abort();
    }
}
