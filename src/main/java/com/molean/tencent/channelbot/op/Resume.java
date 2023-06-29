package com.molean.tencent.channelbot.op;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.annotations.OpCode;
import lombok.Data;

@OpCode(6)
@Data
public class Resume {
    private String token;
    @SerializedName("session_id")
    private String sessionId;
    private Integer seq;
}
