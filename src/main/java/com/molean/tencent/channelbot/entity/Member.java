package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Member {
    /*
    user	UserCommand	用户的频道基础信息，只有成员相关接口中会填充此信息
    nick	string	用户的昵称
    roles	string 数组	用户在频道内的身份组ID, 默认值可参考DefaultRoles
    joined_at	ISO8601 timestamp	用户加入频道的时间
     */

    private User user;
    private String nick;
    private List<String> roles;
    @SerializedName("joined_at")
    private Timestamp joinedAt;
}
