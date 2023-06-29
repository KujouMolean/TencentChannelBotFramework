package com.molean.tencent.channelbot.entity;

import lombok.Data;

import java.util.List;

@Data
public class MessageArkObj {
    /*
    字段名	类型	描述
    obj_kv	MessageArkObjKv objkv类型的数组	ark objkv列表
     */
    private List<MessageArkObjKv> obj_kv;
}
