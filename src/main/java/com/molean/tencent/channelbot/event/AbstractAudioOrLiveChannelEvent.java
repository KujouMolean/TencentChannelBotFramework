package com.molean.tencent.channelbot.event;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.entity.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class AbstractAudioOrLiveChannelEvent {
    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("channel_type")
    private Channel.ChannelType channelType;
    @SerializedName("user_id")
    private String userId;
}
