package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/*
guild_id	string	频道 id
channel_id	string	子频道 id
message_ids	string 数组	子频道内精华消息 id 数组
 */
@Data
public class PinsMessage {
    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("message_ids")
    private List<String> messageIds;

}
