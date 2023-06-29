package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Guild;
import it.unimi.dsi.fastutil.Pair;

public class GuildService {

    private BotApiAccess botApiAccess;

    private Gson gson;

    public GuildService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public Guild getGuildById(String id) {
        JsonElement jsonElement = botApiAccess.request("GET /guilds/{guild}", Pair.of("guild", id));
        return gson.fromJson(jsonElement, Guild.class);
    }
}

