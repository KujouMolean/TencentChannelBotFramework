package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ThreadInfo {
    /*
    thread_id	string	主帖ID
title	string	帖子标题
content	string	帖子内容
date_time	ISO8601 timestamp	发表时间
     */
    @SerializedName("thread_id")
    private String threadId;
    private String title;
    private String content;
    @SerializedName("date_time")
    private Timestamp dateTime;

}
