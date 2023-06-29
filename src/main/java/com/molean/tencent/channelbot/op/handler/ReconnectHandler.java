package com.molean.tencent.channelbot.op.handler;

import com.molean.tencent.channelbot.Bot;
import com.molean.tencent.channelbot.Payload;
import com.molean.tencent.channelbot.annotations.OpHandler;
import com.molean.tencent.channelbot.annotations.OpHandlerTarget;
import com.molean.tencent.channelbot.op.Reconnect;

@OpHandlerTarget(Reconnect.class)
public class ReconnectHandler implements OpHandler<Reconnect> {
    @Override
    public void handle(Bot bot, Payload<Reconnect> payload) {
        bot.getBotWebSocket().reconnect(false);
        bot.getBotAccess().getLogger().info("Bot is reconnecting..");
    }
}
