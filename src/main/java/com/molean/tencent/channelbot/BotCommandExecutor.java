package com.molean.tencent.channelbot;

import com.molean.tencent.channelbot.entity.Message;

import java.util.List;

public interface BotCommandExecutor {
    void execute(Bot bot, Message user, String cmd, List<String> args) throws Exception;
}
