package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.AudioAction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("AUDIO_ON_MIC")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AudioOnMicEvent extends AudioAction {
}
