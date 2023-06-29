package com.molean.tencent.channelbot.op.handler;

import com.molean.tencent.channelbot.Bot;
import com.molean.tencent.channelbot.Payload;
import com.molean.tencent.channelbot.annotations.OpHandler;
import com.molean.tencent.channelbot.annotations.OpHandlerTarget;
import com.molean.tencent.channelbot.op.Hello;
import com.molean.tencent.channelbot.op.Identify;
import com.molean.tencent.channelbot.op.Resume;

import java.util.List;

@OpHandlerTarget(Hello.class)
public class HelloHandler implements OpHandler<Hello> {
    @Override
    public void handle(Bot bot, Payload<Hello> payload) {
        if (bot.getSession() != null) {
            Payload<Resume> resumePayload = new Payload<>();
            Resume resume = new Resume();
            resume.setSessionId(bot.getSession());
            resume.setToken(bot.getBotAccess().getAuthorization());
            resume.setSeq(bot.getBotWebSocketListener().getSequence());
            resumePayload.setOp(6);
            resumePayload.setD(resume);
            bot.getBotWebSocket().sendPayload(resumePayload);
        }else{
            int heartbeatInterval = payload.getD().getHeartbeatInterval();
            bot.getBotWebSocketListener().setHeartbeatInterval(heartbeatInterval);
            Payload<Identify> identifyPayload = new Payload<>();
            Identify identify = new Identify();
            long i = 0;
            for (Identify.Intents value : Identify.Intents.values()) {
                i += value.getValue();
            }
            identify.setIntents(i);
            identify.setToken(bot.getBotAccess().getAuthorization());
            identify.setShard(List.of(0, 1));
            identifyPayload.setOp(2);
            identifyPayload.setD(identify);
            bot.getBotWebSocket().sendPayload(identifyPayload);
        }

    }
}
