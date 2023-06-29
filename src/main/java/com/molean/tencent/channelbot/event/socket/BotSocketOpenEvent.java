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
public class BotSocketOpenEvent extends BotSocketEvent{
    public BotSocketOpenEvent(Bot bot, WebSocket webSocket) {
        super(bot,webSocket);
    }
}
