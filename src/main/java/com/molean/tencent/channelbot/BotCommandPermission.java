package com.molean.tencent.channelbot;

import com.molean.tencent.channelbot.entity.User;

public interface BotCommandPermission {
    boolean hasPermission(User user, String permission);
}
