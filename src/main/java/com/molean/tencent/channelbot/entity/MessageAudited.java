package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MessageAudited {
    /*
    audit_id	string	消息审核 id
    message_id	string	消息 id，只有审核通过事件才会有值
    guild_id	string	频道 id
    channel_id	string	子频道 id
    audit_time	ISO8601 timestamp	消息审核时间
    create_time	ISO8601 timestamp	消息创建时间
    seq_in_channel	string	子频道消息 seq，用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序
     */

    @SerializedName("audit_id")
    private String auditId;
    @SerializedName("message_id")
    private String messageId;
    @SerializedName("guildId")
    private String guild_id;
    @SerializedName("channelId")
    private String channel_id;
    @SerializedName("auditTime")
    private String audit_time;
    @SerializedName("createTime")
    private String create_time;
    @SerializedName("seqInChannel")
    private String seq_in_channel;
}
