package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AtInfo {
    /*
    AT_EXPLICIT_USER	1	at特定人
    AT_ROLE_GROUP	2	at角色组所有人
    AT_GUILD	3	at频道所有人
     */
    public enum AtType {
        @SerializedName("1")
        AT_EXPLICIT_USER,
        @SerializedName("2")
        AT_ROLE_GROUP,
        @SerializedName("3")
        AT_GUILD,
    }
}
