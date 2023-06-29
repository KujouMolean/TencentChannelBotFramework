package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("OPEN_FORUM_POST_CREATE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OpenForumPostCreateEvent extends AbstractOpenForumEvent {

}
