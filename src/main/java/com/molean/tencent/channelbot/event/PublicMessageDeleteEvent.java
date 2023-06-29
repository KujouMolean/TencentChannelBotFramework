package com.molean.tencent.channelbot.event;


import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("PUBLIC_MESSAGE_DELETE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PublicMessageDeleteEvent extends Message {
}
