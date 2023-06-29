package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.MessageReaction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("MESSAGE_REACTION_ADD")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MessageReactionAddEvent extends MessageReaction {
}
