package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
audio_url	string	音频数据的url status为0时传
text	string	状态文本（比如：简单爱-周杰伦），可选，status为0时传，其他操作不传
status	STATUS	播放状态，参考 STATUS
 */
@Data
public class AudioControl {
    /*
    START	0	开始播放操作
    PAUSE	1	暂停播放操作
    RESUME	2	继续播放操作
    STOP	3	停止播放操作
     */
    public enum AudioStatus {
        @SerializedName("0")
        START,
        @SerializedName("1")
        PAUSE,
        @SerializedName("2")
        RESUME,
        @SerializedName("3")
        STOP,

    }
    @SerializedName("audio_url")
    private String audioUrl;
    private String text;
    private AudioStatus audioStatus;

}
