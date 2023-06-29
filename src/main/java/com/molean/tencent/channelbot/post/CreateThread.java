package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
title	string	帖子标题
content	string	帖子内容
format	uint32	帖子文本格式
 */
@Data
public class CreateThread {
    public enum Format{
        @SerializedName("1")
        FORMAT_TEXT,
        @SerializedName("2")
        FORMAT_HTML,
        @SerializedName("3")
        FORMAT_MARKDOWN,
        @SerializedName("4")
        FORMAT_JSON
    }
    private String title;
    private String content;
    private Format format;
}
