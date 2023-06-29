package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.AuditResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("FORUM_PUBLISH_AUDIT_RESULT")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ForumPublishAuditResultEvent extends AuditResult {

}
