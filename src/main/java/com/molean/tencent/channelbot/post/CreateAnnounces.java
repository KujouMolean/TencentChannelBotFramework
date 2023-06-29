package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.entity.Announces;
import com.molean.tencent.channelbot.entity.RecommendChannel;
import lombok.Data;

import java.util.List;

@Data
public class CreateAnnounces {
    public enum AnnounceType{
        @SerializedName("0") MEMBER, @SerializedName("1") WELCOME,
    }

    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("announce_type")
    private Announces.AnnounceType announceType;
    @SerializedName("recommend_channels")
    private List<RecommendChannel> recommendChannels;
}
