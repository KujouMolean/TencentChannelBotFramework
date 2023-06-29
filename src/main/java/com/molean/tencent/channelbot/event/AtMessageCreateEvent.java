package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("AT_MESSAGE_CREATE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AtMessageCreateEvent extends Message {

}
