package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.Thread;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("FORUM_THREAD_UPDATE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForumThreadUpdateEvent extends Thread {
}
