package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PostInfo {
    /*thread_id	string	主题ID
post_id	string	帖子ID
content	string	帖子内容
date_time	string	评论时间
     */

    @SerializedName("thread_id")
    private String threadId;
    @SerializedName("post_id")
    private String postId;
    private String content;
    @SerializedName("date_time")
    private String dateTime;
}
