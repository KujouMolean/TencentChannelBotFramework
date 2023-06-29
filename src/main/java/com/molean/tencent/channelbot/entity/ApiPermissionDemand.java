package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
guild_id	string	申请接口权限的频道 id
channel_id	string	接口权限需求授权链接发送的子频道 id
api_identify	APIPermissionDemandIdentify	权限接口唯一标识
title	string	接口权限链接中的接口权限描述信息
desc	string	接口权限链接中的机器人可使用功能的描述信息
 */
@Data
public class ApiPermissionDemand {
    @SerializedName("guildId")
    private String guildId;
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("api_identify")
    private APIPermissionDemandIdentify apiIdentify;
    private String title;
    private String desc;


}
