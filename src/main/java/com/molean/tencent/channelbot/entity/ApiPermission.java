package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
path	string	API 接口名，例如 /guilds/{guild_id}/members/{user_id}
method	string	请求方法，例如 GET
desc	string	API 接口名称，例如 获取频道信
auth_status	int	授权状态，auth_stats 为 1 时已授权
 */
@Data
public class ApiPermission {
    private String path;
    private String method;
    private String desc;
    @SerializedName("auth_status")
    private int authStatus;

}
