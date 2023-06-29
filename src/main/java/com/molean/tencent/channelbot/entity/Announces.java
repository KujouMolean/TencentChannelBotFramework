package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.post.CreateAnnounces;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
    guild_id	string	频道 id
    channel_id	string	子频道 id
    message_id	string	消息 id
    announces_type	uint32	公告类别 0:成员公告 1:欢迎公告，默认成员公告
    recommend_channels	RecommendChannel 数组	推荐子频道详情列表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Announces extends CreateAnnounces {
    @SerializedName("message_id")
    private String messageId;

}
