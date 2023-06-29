package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class MessageArk {
    /*
    字段名	类型	描述
    template_id	int	ark模板id（需要先申请）
    kv	MessageAkrKv arkkv数组	kv值列表
     */

    @SerializedName("template_id")
    private Integer templateId;
    private List<MessageArkKv> kv;
}
