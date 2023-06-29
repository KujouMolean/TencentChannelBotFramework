package com.molean.tencent.channelbot.event.socket;

import com.molean.tencent.channelbot.Bot;
import lombok.Data;

import java.net.http.WebSocket;

@Data
public class BotSocketEvent {
    private Bot bot;
    private WebSocket webSocket;

    public BotSocketEvent(Bot bot,WebSocket webSocket) {
        this.bot = bot;
        this.webSocket = webSocket;
    }
}
