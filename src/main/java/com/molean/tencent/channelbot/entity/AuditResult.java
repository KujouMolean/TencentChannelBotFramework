package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AuditResult {
    /*
        guild_id	string	频道ID
        channel_id	string	子频道ID
        author_id	string	作者ID
        thread_id	string	主题ID
        post_id	string	帖子ID
        reply_id	string	回复ID
        type	uint32	AuditType审核的类型
        result	uint32	审核结果. 0:成功 1:失败
        err_msg	string	result不为0时错误信息
     */

    public enum AuditType{
        @SerializedName("0") SUCCESS,
        @SerializedName("1") FAILED
    }
    @SerializedName("guild_id")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("author_id")
    private String authorId;
    @SerializedName("thread_id")
    private String threadId;
    @SerializedName("post_id")
    private String postId;
    @SerializedName("reply_id")
    private String replyId;
    private AuditType type;
    private AuditResult result;
    @SerializedName("err_msg")
    private String errMsg;

}
