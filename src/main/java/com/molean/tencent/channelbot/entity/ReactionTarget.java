package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ReactionTarget {
    /*
    字段名	类型	描述
    id	string	表态对象ID
    type	ReactionTargetType	表态对象类型，参考 ReactionTargetType
     */

    public enum ReactionTargetType{
        /*
        0	消息
        1	帖子
        2	评论
        3	回复
         */
        @SerializedName("0") MESSAGE,
        @SerializedName("1") THREAD,
        @SerializedName("2") POST,
        @SerializedName("3") REPLY,


    }
    private String id;
    private ReactionTargetType type;
}
