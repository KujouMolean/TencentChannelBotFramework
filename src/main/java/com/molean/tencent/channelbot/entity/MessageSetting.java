package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/*
    disable_create_dm	string	是否允许创建私信
    disable_push_msg	string	是否允许发主动消息
    channel_ids	string 数组	子频道 id 数组
    channel_push_max_num	uint32	每个子频道允许主动推送消息最大消息条数
 */
@Data
public class MessageSetting {
    @SerializedName("disable_create_dm")
    private String disableCreateDm;
    @SerializedName("disable_push_msg")
    private String disablePushMsg;
    @SerializedName("channel_ids")
    private List<String> channelIds;
    @SerializedName("channel_push_max_num")
    private int channelPushMaxNum;

}
