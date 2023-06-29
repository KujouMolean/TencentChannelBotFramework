package com.molean.tencent.channelbot.op.handler;

import com.molean.tencent.channelbot.Bot;
import com.molean.tencent.channelbot.Payload;
import com.molean.tencent.channelbot.annotations.OpHandler;
import com.molean.tencent.channelbot.annotations.OpHandlerTarget;
import com.molean.tencent.channelbot.op.HeartbeatACK;

@OpHandlerTarget(HeartbeatACK.class)
public class HeartbeatACKHandler implements OpHandler<HeartbeatACK> {
    @Override
    public void handle(Bot bot, Payload<HeartbeatACK> payload) {
        bot.getBotWebSocket().setLastHeartbeatACK(System.currentTimeMillis());
        bot.getBotAccess().getLogger().info("Received server heartbeat ACK.");

    }
}
