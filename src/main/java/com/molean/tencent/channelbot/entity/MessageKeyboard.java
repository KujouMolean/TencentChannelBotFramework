package com.molean.tencent.channelbot.entity;

import lombok.Data;

/*
id	string	keyboard 模板 id
content	InlineKeyboard 对象	自定义 keyboard 内容,与 id 参数互斥,参数都传值将报错。
 */
@Data
public class MessageKeyboard {
    private String id;
    private InlineKeyboard content;

}
