package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("FORUM_POST_DELETE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForumPostDeleteEvent extends Post {
}
