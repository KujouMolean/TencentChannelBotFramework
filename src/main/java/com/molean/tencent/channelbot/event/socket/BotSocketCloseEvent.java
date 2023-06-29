package com.molean.tencent.channelbot.event.socket;

import com.molean.tencent.channelbot.Bot;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.http.WebSocket;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BotSocketCloseEvent extends BotSocketEvent {

    private int statusCode;
    private String reason;

    public BotSocketCloseEvent(Bot bot, WebSocket webSocket, int statusCode, String reason) {
        super(bot,webSocket);
        this.statusCode = statusCode;
        this.reason = reason;
    }
}
