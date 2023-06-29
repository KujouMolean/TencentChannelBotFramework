package com.molean.tencent.channelbot.entity;

import lombok.Data;
/*
path	string	API 接口名，例如 /guilds/{guild_id}/members/{user_id}
method	string	请求方法，例如 GET
 */
@Data
public class APIPermissionDemandIdentify {
    private String path;
    private String method;

}
