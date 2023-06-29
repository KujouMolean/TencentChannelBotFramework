package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Reply {
    /*
    guild_id	string	频道ID
channel_id	string	子频道ID
author_id	string	作者ID
reply_info	object	ReplyInfo 回复内容
     */

    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("author_id")
    private String authorId;
    @SerializedName("reply_info")
    private ReplyInfo replyInfo;
}
