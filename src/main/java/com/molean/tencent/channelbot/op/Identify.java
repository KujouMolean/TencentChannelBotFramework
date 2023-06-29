package com.molean.tencent.channelbot.op;

import com.molean.tencent.channelbot.annotations.OpCode;
import lombok.Data;

import java.util.List;

@OpCode(2)
@Data
public class Identify {
    public enum Intents {
        GUILDS(1L),
        GUILD_MEMBERS(1L << 1),
        GUILD_MESSAGES(1L << 9),
        GUILD_MESSAGE_REACTIONS(1L << 10),
        DIRECT_MESSAGE(1L << 12),
        OPEN_FORUMS_EVENT(1L << 18),
        AUDIO_OR_LIVE_CHANNEL_MEMBER(1L << 19),
        INTERACTION(1L << 26),
        MESSAGE_AUDIT(1L << 27),
        FORUMS_EVENT(1L << 28),
        AUDIO_ACTION(1L << 29),
        PUBLIC_GUILD_MESSAGES(1 << 30);

        private final long value;

        Intents(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }
    }

    private String token;
    private Long intents;
    private List<Integer> shard;
}
