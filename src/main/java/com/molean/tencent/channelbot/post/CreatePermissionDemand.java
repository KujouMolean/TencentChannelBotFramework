package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.entity.APIPermissionDemandIdentify;
import lombok.Data;

/*
channel_id	string	授权链接发送的子频道 id
api_identify	APIPermissionDemandIdentify 对象	api 权限需求标识对象
desc	string	机器人申请对应的 API 接口权限后可以使用功能的描述
 */
@Data
public class CreatePermissionDemand {
    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("api_identify")
    private APIPermissionDemandIdentify apiIdentify;
    private String desc;
}
