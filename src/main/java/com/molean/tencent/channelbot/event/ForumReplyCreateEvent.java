package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.Reply;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("FORUM_REPLY_CREATE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForumReplyCreateEvent extends Reply {
}
