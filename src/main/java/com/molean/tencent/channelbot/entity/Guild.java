package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Guild {

    /*
        字段名	类型	描述
        id	string	频道ID
        name	string	频道名称
        icon	string	频道头像地址
        owner_id	string	创建人用户ID
        owner	bool	当前人是否是创建人
        member_count	int	成员数
        max_members	int	最大成员数
        description	string	描述
        joined_at	string	加入时间
     */
    private String id;
    private String name;
    private String icon;
    @SerializedName("owner_id")
    private String ownerId;
    private Boolean owner;
    @SerializedName("member_count")
    private int memberCount;
    @SerializedName("max_members")
    private Integer maxMembers;
    private String description;
    @SerializedName("joined_at")
    private String joinedAt;
}
