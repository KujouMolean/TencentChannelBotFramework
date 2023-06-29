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
public class BotSocketTextEvent extends BotSocketEvent{
    private String data;

    public BotSocketTextEvent(Bot bot, WebSocket webSocket, String data) {
        super(bot,webSocket);
        this.data = data;
    }
}
