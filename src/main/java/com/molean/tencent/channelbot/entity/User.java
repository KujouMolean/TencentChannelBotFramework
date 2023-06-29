package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class User {
    /*
    id	string	用户 id
username	string	用户名
avatar	string	用户头像地址
bot	bool	是否是机器人
union_openid	string	特殊关联应用的 openid，需要特殊申请并配置后才会返回。如需申请，请联系平台运营人员。
union_user_account	string	机器人关联的互联应用的用户信息，与union_openid关联的应用是同一个。如需申请，请联系平台运营人员。
#
     */
    private String id;
    private String username;
    private String avatar;
    private Boolean bot;
    @SerializedName("union_openid")
    private String unionOpenId;
    @SerializedName("union_user_account")
    private String unionUserAccount;
}
