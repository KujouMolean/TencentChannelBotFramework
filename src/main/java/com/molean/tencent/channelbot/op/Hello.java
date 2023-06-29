package com.molean.tencent.channelbot.op;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.annotations.OpCode;
import lombok.Data;

@OpCode(10)
@Data
public class Hello {
    @SerializedName("heartbeat_interval")
    private int heartbeatInterval;
}
