package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
role_id	uint64	身份组ID
name	string	身份组名称
color	uint32	颜色值
#
 */
@Data
public class AtRoleInfo {
    @SerializedName("role_id")
    private long roleId;
    private String name;
    private int color;

}
