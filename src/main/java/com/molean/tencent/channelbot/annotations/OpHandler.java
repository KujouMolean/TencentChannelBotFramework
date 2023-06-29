package com.molean.tencent.channelbot.annotations;

import com.molean.tencent.channelbot.Bot;
import com.molean.tencent.channelbot.Payload;

public interface OpHandler<T> {

    void handle(Bot bot, Payload<T> payload);
}
