package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
guild_id	string	频道ID
guild_name	string	频道名称
 */
@Data
public class AtGuildInfo {
    @SerializedName("guildId")
    private String guildId;
    @SerializedName("guildName")
    private String guildName;

}
