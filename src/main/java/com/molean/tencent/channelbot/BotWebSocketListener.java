package com.molean.tencent.channelbot;

import com.google.gson.*;
import com.molean.tencent.channelbot.annotations.OpHandler;
import com.molean.tencent.channelbot.event.EventIdEvent;
import com.molean.tencent.channelbot.event.socket.BotSocketCloseEvent;
import com.molean.tencent.channelbot.event.socket.BotSocketOpenEvent;
import com.molean.tencent.channelbot.event.socket.BotSocketTextEvent;
import lombok.Getter;
import lombok.Setter;

import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

public class BotWebSocketListener implements WebSocket.Listener {
    private final Gson gson;
    @Getter
    @Setter
    private int heartbeatInterval;
    @Getter
    @Setter
    private int sequence = 0;
    private final Bot bot;


    public BotWebSocketListener(Bot bot, Gson gson) {
        this.gson = gson;
        this.bot = bot;
    }

    @Override
    public void onOpen(WebSocket webSocket) {
        try {
            if (bot.getBotWebSocket().getWebSocket() == null) {
                bot.getBotWebSocket().setWebSocket(webSocket);
            }
            BotSocketOpenEvent botSocketOpenEvent = new BotSocketOpenEvent(bot, webSocket);
            bot.getEventBus().post(botSocketOpenEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebSocket.Listener.super.onOpen(webSocket);
    }

    private void updateSequence(Payload<Object> payload) {

        if (payload.getS() != null && payload.getS() > 0) {
            this.sequence = payload.getS();
        }
    }

    public void onOperation(int op, String data) {
        Class<?> opEntityClass = BotRegistrationProvider.INSTANCE.getOpEntityMap().get(op);
        if (opEntityClass == null) {
            bot.getBotAccess().getLogger().warning(bot.getBotAccess().getLoggerNamespace() + ": Unexpected op code: " + op);
            return;
        }
        Payload<?> parse = null;
        try {
            //reparse
            parse = Payload.parse(data, opEntityClass);
        } catch (Exception e) {
            bot.getBotAccess().getLogger().severe("Error while parsing payload:" + data);
            throw new RuntimeException(e);
        }
        if (parse.getD() == null) {
            try {
                Object opObject = opEntityClass.getDeclaredConstructor().newInstance();
                ((Payload<Object>) (parse)).setD(opObject);
            } catch (Exception e) {
                bot.getBotAccess().getLogger().severe("Unable create op object with id:" + op);
                throw new RuntimeException(e);
            }
        }
        Object d = parse.getD();
        bot.getBotAccess().getLogger().info("Received op: " + parse);
        for (OpHandler<Object> opHandler : BotRegistrationProvider.INSTANCE.getOpHandlerMap().get(d.getClass())) {
            try {
                opHandler.handle(bot, (Payload<Object>) parse);
            } catch (Exception e) {
                bot.getBotAccess().getLogger().severe("Error while handle op code: " + op);
                e.printStackTrace();
            }
        }
    }

    public void onEventDispatch(String type, String data) {
        JsonObject d;
        try {
            JsonElement jsonElement = JsonParser.parseString(data).getAsJsonObject().get("d");
            if (jsonElement.isJsonObject()) {
                d = jsonElement.getAsJsonObject();
            } else {
                d = new JsonObject();
            }
        } catch (Exception e) {
            bot.getBotAccess().getLogger().warning("Error while parsing event dispatch: \n" + data);
            throw new RuntimeException(e);
        }
        Class<?> aClass = BotRegistrationProvider.INSTANCE.getEventMap().get(type);
        if (aClass == null) {
            bot.getBotAccess().getLogger().warning("Unknown event: " + type);
            return;
        }
        Object obj;
        try {
            obj = gson.fromJson(d, aClass);
        } catch (JsonSyntaxException e) {
            bot.getBotAccess().getLogger().warning("Error while parsing event " + type + ": \n" + gson.toJson(d));
            throw new RuntimeException(e);
        }
        bot.getBotAccess().getLogger().info("Received event: " + obj);
        try {
            bot.getEventBus().post(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (JsonParser.parseString(data).getAsJsonObject().has("id")) {
            String id = JsonParser.parseString(data).getAsJsonObject().get("id").getAsString();
            EventIdEvent eventIdEvent = new EventIdEvent();
            eventIdEvent.setEvent(obj);
            eventIdEvent.setId(id);
            try {
                bot.getEventBus().post(eventIdEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        try {
            if (bot.isDestroyed()) {
                webSocket.abort();
            } else {
                if (bot.getBotWebSocket().getWebSocket() == null) {
                    bot.getBotWebSocket().setWebSocket(webSocket);
                }
                BotSocketTextEvent botSocketTextEvent = new BotSocketTextEvent(bot, webSocket, data.toString());
                bot.getEventBus().post(botSocketTextEvent);
                Payload<Object> payload = Payload.parse(data.toString(), Object.class);
                updateSequence(payload);
                int op = payload.getOp();
                if (op == 0) {
                    onEventDispatch(payload.getT(), data.toString());
                } else {
                    onOperation(op, data.toString());
                }
            }
        } catch (Exception e) {
            bot.getBotAccess().getLogger().warning("Error while receive text: ");
            bot.getBotAccess().getLogger().warning(data.toString());
            e.printStackTrace();
        }
        return WebSocket.Listener.super.onText(webSocket, data, last);
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
        WebSocket.Listener.super.onError(webSocket, error);
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        try {
            BotSocketCloseEvent botSocketCloseEvent = new BotSocketCloseEvent(bot, webSocket, statusCode, reason);
            bot.getEventBus().post(botSocketCloseEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
    }
}
