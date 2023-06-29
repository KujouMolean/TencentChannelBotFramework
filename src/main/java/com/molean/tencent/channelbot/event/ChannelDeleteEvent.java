package com.molean.tencent.channelbot.event;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EventType("CHANNEL_DELETE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChannelDeleteEvent extends Channel {
    @SerializedName("op_user_id")
    private String opUserId;
}
