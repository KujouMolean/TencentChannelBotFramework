package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public abstract class AbstractMute {
    @SerializedName("mute_end_time_stamp")
    private String muteEndTimestamp;
    @SerializedName("mute_seconds")
    private String muteSeconds;
}
