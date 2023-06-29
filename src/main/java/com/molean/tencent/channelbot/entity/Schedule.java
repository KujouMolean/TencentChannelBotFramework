package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
id	string	日程 id
name	string	日程名称
description	string	日程描述
start_timestamp	string	日程开始时间戳(ms)
end_timestamp	string	日程结束时间戳(ms)
creator	Member	创建者
jump_channel_id	string	日程开始时跳转到的子频道 id
remind_type	string	日程提醒类型，取值参考RemindType
 */
@Data
public class Schedule {
    public enum RemindType{
        /*
        0	不提醒
        1	开始时提醒
        2	开始前 5 分钟提醒
        3	开始前 15 分钟提醒
        4	开始前 30 分钟提醒
        5	开始前 60 分钟提醒
         */
        @SerializedName("0")
        NO_REMIND,
        @SerializedName("1")
        BEFORE_START,
        @SerializedName("2")
        BEFORE_START_5_MIN,
        @SerializedName("3")
        BEFORE_START_15_MIN,
        @SerializedName("4")
        BEFORE_START_30_MIN,
        @SerializedName("5")
        BEFORE_START_60MIN

    }

    private String id;
    private String name;
    private String description;
    @SerializedName("start_timestamp")
    private String startTimestamp;
    @SerializedName(("end_timestamp"))
    private String endTimestamp;
    private Member creator;
    @SerializedName("jumpChannelId")
    private String jumpChannelId;
    @SerializedName("remind_type")
    private RemindType remindType;
}
