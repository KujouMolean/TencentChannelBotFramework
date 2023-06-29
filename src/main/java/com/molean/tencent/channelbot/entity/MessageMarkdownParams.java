package com.molean.tencent.channelbot.entity;

import lombok.Data;

import java.util.List;

/*
key	string	markdown 模版 key
values	string 类型的数组	markdown 模版 key 对应的 values ，列表长度大小为 1 代表单 value 值，长度大于1则为列表类型的参数 values 传参数
#
 */
@Data
public class MessageMarkdownParams {
    private String key;
    private List<String> value;

}
