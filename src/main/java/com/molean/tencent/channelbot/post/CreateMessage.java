package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.entity.MessageArk;
import com.molean.tencent.channelbot.entity.MessageEmbed;
import com.molean.tencent.channelbot.entity.MessageMarkdown;
import com.molean.tencent.channelbot.entity.MessageReference;
import lombok.Data;

/**
 * 用于创建频道全局公告，公告类型分为 消息类型的频道公告 和 推荐子频道类型的频道公告 。
 * <p>
 * 当请求参数 message_id 有值时，优先创建消息类型的频道公告， 消息类型的频道公告只能创建成员公告类型的频道公告。
 * 创建推荐子频道类型的频道全局公告请将 message_id 设置为空，并设置对应的 announces_type 和 recommend_channels 请求参数，会一次全部替换推荐子频道公司。
 * 推荐子频道和消息类型全局公告不能同时存在，会互相顶替设置。
 * 同频道内推荐子频道最多只能创建 3 条。
 * 只有子频道权限为全体成员可见才可设置为推荐子频道。
 * 删除推荐子频道类型的频道公告请使用 删除频道公告,并将 message_id 设置为 all。
 */
@Data
public class CreateMessage {
    private String content;
    private MessageEmbed embed;
    private MessageArk ark;
    @SerializedName("message_reference")
    private MessageReference messageReference;
    private String image;
    @SerializedName("msg_id")
    private String msgId;
    @SerializedName("event_id")
    private String eventId;
    private MessageMarkdown markdown;

}
