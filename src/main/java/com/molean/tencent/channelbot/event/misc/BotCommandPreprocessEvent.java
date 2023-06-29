package com.molean.tencent.channelbot.event.misc;

import com.molean.tencent.channelbot.Bot;
import com.molean.tencent.channelbot.entity.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class BotCommandPreprocessEvent {
    private final Bot bot;
    private final Message message;
    private final String content;
    @Setter
    private String command;
    @Setter
    private List<String> args;
    @Setter
    private boolean cancel = false;

    public BotCommandPreprocessEvent(Bot bot, Message message, String content, String command, List<String> args) {
        this.bot = bot;
        this.message = message;
        this.content = content;
        this.command = command;
        this.args = args;
    }
}
