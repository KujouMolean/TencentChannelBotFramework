package com.molean.tencent.channelbot.event;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.annotations.EventType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("OPEN_FORUM_THREAD_DELETE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OpenForumThreadUpdateEvent  extends AbstractOpenForumEvent {
    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("author_id")
    private String authorId;
}
