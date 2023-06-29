package com.molean.tencent.channelbot.event;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.MemberWithGuildId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("GUILD_MEMBER_REMOVE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GuildMemberRemoveEvent extends MemberWithGuildId {
    @SerializedName("op_user_id")
    private String opUserId;
}
