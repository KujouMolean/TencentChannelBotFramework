package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Post {
    /*
    guild_id	string	频道ID
channel_id	string	子频道ID
author_id	string	作者ID
post_info	object	PostInfo 帖子内容
     */

    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("author_id")
    private String authorId;
    @SerializedName("post_info")
    private PostInfo postInfo;
}
