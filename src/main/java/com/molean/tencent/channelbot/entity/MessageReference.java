package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MessageReference {
    /*
    字段名	类型	描述
    message_id	string	需要引用回复的消息 id
    ignore_get_message_error	bool	是否忽略获取引用消息详情错误，默认否
     */
    @SerializedName("message_id")
    private String messageId;
    @SerializedName("ignore_get_message_error")
    private Boolean ignoreGetMessageError;
}
