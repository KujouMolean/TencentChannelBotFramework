package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.annotation.Nullable;
import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Message {
    /*
    字段名	类型	描述
    id	string	消息 id
    channel_id	string	子频道 id
    guild_id	string	频道 id
    content	string	消息内容
    timestamp	ISO8601 timestamp	消息创建时间
    edited_timestamp	ISO8601 timestamp	消息编辑时间
    mention_everyone	bool	是否是@全员消息
    author	UserCommand 对象	消息创建者
    attachments	MessageAttachment 对象数组	附件
    embeds	MessageEmbed 对象数组	embed
    mentions	UserCommand 对象数组	消息中@的人
    member	Member 对象	消息创建者的member信息
    ark	MessageArk ark消息对象	ark消息
    seq	int	用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序。(目前只在消息事件中有值，2022年8月1日 后续废弃)
    seq_in_channel	string	子频道消息 seq，用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序
    message_reference	MessageReference 对象	引用消息对象
    src_guild_id	string	用于私信场景下识别真实的来源频道id
     */
    private String id;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("guild_id")
    private String guildId;
    private String content;
    private Timestamp timestamp;
    @SerializedName("edited_timestamp")
    private Timestamp editedTimestamp;
    @SerializedName("mention_everyone")
    private Boolean mentionEveryone;
    private User author;
    private List<MessageAttachment> attachments;
    private List<MessageEmbed> embeds;
    private List<User> mentions;
    private Member member;
    private MessageArk ark;
    private Integer seq;
    @SerializedName("seq_in_channel")
    private String seqInChannel;
    @SerializedName("message_reference")
    private MessageReference messageReference;
    @SerializedName("src_guild_id")
    private String srcGuildId;
}
