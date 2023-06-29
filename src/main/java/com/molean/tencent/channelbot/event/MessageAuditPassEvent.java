package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.MessageAudited;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("MESSAGE_AUDIT_PASS")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MessageAuditPassEvent extends MessageAudited {
}
