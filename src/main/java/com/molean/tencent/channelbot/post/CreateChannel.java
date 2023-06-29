package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.entity.Channel;
import lombok.Data;

import java.util.List;

/*
        name	string	子频道名称
        type	int	子频道类型 ChannelType
        sub_type	int	子频道子类型 ChannelSubType
        position	int	子频道排序，必填；当子频道类型为 子频道分组（ChannelType=4）时，必须大于等于 2
        parent_id	string	子频道所属分组ID
        private_type	int	子频道私密类型 PrivateType
        private_user_ids	string 数组	子频道私密类型成员 ID
        speak_permission	int	子频道发言权限 SpeakPermission
        application_id	string	应用类型子频道应用 AppID，仅应用子频道需要该字段
     */
@Data
public class CreateChannel {

    private String name;
    private Channel.ChannelType type;
    @SerializedName("sub_type")
    private Channel.ChannelSubType subType;
    private Integer position;
    @SerializedName("parent_id")
    private String parentId;
    private Channel.PrivateType privateType;
    @SerializedName("private_user_ids")
    private List<String> privateUserIds;
    @SerializedName("speak_permission")
    private Channel.SpeakPermission speakPermission;
    @SerializedName("application_id")
    private Channel.ApplicationType applicationType;

}
