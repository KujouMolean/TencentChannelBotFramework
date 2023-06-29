package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.entity.Channel;
import lombok.Data;

/*
    name	string	子频道名
    position	int	排序
    parent_id	string	分组 id
    private_type	int	子频道私密类型 PrivateType
    speak_permission	int	子频道发言权限 SpeakPermission
 */
@Data
public class UpdateChannel {
    private String name;
    private Integer position;
    @SerializedName("private_type")
    private Channel.PrivateType privateType;
    @SerializedName("speak_permission")
    private Channel.SpeakPermission speakPermission;
}
