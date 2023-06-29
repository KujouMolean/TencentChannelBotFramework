package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
task_id	string	帖子任务ID
create_time	string	发帖时间戳，单位：秒
 */
@Data
public class CreateThreadResult {
    @SerializedName("task_id")
    private String taskId;
    @SerializedName("create_time")
    private String createTime;

}
