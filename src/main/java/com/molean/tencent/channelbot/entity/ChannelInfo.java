package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
channel_id	uint64	子频道id
channel_name	string	子频道名称
 */
@Data
public class ChannelInfo {
    @SerializedName("channel_id")
    private Long channelId;
    @SerializedName("channel_name")
    private String channelName;

}
