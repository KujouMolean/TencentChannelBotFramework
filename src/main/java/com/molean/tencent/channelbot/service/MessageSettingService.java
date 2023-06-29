package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.MessageSetting;
import it.unimi.dsi.fastutil.Pair;

public class MessageSettingService {
    private BotApiAccess botApiAccess;

    private Gson gson;

    public MessageSettingService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public MessageSetting getGuildMessageSetting(String guildId) {
        JsonElement request = botApiAccess.request("GET /guilds/{guild_id}/message/setting",
                Pair.of("guild_id", guildId));
        return gson.fromJson(request, MessageSetting.class);
    }
}
