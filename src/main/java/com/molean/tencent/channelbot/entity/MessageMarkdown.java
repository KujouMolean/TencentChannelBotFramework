package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
template_id	int	markdown 模板 id
params	MessageMarkdownParams	markdown 模板模板参数
content	string	原生 markdown 内容,与 template_id 和 params参数互斥,参数都传值将报错。
 */
@Data
public class MessageMarkdown {

    @SerializedName("template_id")
    private int templateId;
    private MessageMarkdownParams params;
    private String content;

}
