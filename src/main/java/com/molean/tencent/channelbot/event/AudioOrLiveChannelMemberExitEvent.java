package com.molean.tencent.channelbot.event;

import com.molean.tencent.channelbot.annotations.EventType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EventType("AUDIO_OR_LIVE_CHANNEL_MEMBER_EXIT")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AudioOrLiveChannelMemberExitEvent extends AbstractAudioOrLiveChannelEvent{
}
