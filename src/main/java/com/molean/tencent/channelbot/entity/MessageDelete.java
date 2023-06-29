package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
message	Message 对象	被删除的消息内容
op_user	UserCommand 对象	执行删除操作的用户
 */
@Data
public class MessageDelete {
    private Message message;
    @SerializedName("op_user")
    private User opUser;


}
