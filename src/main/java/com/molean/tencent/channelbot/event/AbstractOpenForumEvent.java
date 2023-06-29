package com.molean.tencent.channelbot.event;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public abstract class AbstractOpenForumEvent {
    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("author_id")
    private String authorId;
}
