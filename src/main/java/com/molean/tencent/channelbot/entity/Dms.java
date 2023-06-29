package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
    guild_id	string	私信会话关联的频道 id
    channel_id	string	私信会话关联的子频道 id
    create_time	string	创建私信会话时间戳
 */
@Data
public class Dms /*Direct Message*/ {
    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("create_time")
    private String createTime;
}
