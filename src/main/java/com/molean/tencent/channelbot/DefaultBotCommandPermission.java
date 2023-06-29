package com.molean.tencent.channelbot;

import com.molean.tencent.channelbot.entity.User;

public class DefaultBotCommandPermission implements BotCommandPermission {
    @Override
    public boolean hasPermission(User user, String permission) {
        return true;
    }
}
