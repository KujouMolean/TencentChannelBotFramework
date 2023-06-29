package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ReplyInfo {
    /*
    thread_id	string	主题ID
post_id	string	帖子ID
reply_id	string	回复ID
content	string	回复内容
date_time	string	回复时间
     */

    @SerializedName("thread_id")
    private String threadId;
    @SerializedName("post_id")
    private String postId;

    @SerializedName("reply_id")
    private String replyId;
    private String content;
    @SerializedName("date_time")
    private String dateTime;
}

