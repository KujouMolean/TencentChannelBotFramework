package com.molean.tencent.channelbot.entity;

import lombok.Data;

import java.util.List;

@Data
public class MessageEmbed {
    /*
        字段名	类型	描述
        title	string	标题
        prompt	string	消息弹窗内容
        thumbnail	MessageEmbedThumbnail 对象	缩略图
        fields	MessageEmbedField 对象数组	embed 字段数据

     */
    private String title;
    private String prompt;
    private MessageEmbedThumbnail thumbnail;
    private List<MessageEmbedField> fields;

}
