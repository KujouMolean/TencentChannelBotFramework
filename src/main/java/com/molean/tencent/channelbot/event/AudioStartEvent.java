package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.AudioAction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("AUDIO_START")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AudioStartEvent extends AudioAction {

}
