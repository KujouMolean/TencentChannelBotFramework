package com.molean.tencent.channelbot;

import java.util.Locale;

public interface BotCommandMap {
    void registerCommand(String cmd, BotCommandExecutor executor);

    boolean isRegistered(String cmd);
}
