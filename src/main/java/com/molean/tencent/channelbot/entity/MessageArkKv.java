package com.molean.tencent.channelbot.entity;

import lombok.Data;

import java.util.List;

@Data
public class MessageArkKv {
    /*
    key	string	key
    value	string	value
    obj	MessageArkObj arkobj类型的数组	ark obj类型的列表
     */
    private String key;
    private String value;
    private List<MessageArkObj> obj;
}
