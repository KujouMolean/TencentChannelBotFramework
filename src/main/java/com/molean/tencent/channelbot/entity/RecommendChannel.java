package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
channel_id	string	子频道 id
introduce	string	推荐语
 */
@Data
public class RecommendChannel {
    @SerializedName("channel_id")
    private String channelId;
    private String introduce;
}
