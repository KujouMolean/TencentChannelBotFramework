package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AudioAction {
    /*
    guild_id	string	频道id
    channel_id	string	子频道id
    audio_url	string	音频数据的url status为0时传
    text	string	状态文本（比如：简单爱-周杰伦），可选，status为0时传，其他操作不传
     */

    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("audio_url")
    private String audioUrl;
    private String text;

}
