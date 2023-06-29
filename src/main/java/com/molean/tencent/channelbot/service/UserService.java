package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Guild;
import com.molean.tencent.channelbot.entity.User;
import it.unimi.dsi.fastutil.Pair;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final BotApiAccess botApiAccess;

    private final Gson gson;

    public UserService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public User getSelf() {
        JsonElement jsonElement = botApiAccess.request("GET /users/@me");
        return gson.fromJson(jsonElement, User.class);
    }

    public List<Guild> getGuilds() {
        JsonElement jsonElement = botApiAccess.request("GET /users/@me/guilds");
        ArrayList<Guild> guilds = new ArrayList<>();
        for (JsonElement element : jsonElement.getAsJsonArray()) {
            guilds.add(gson.fromJson(element, Guild.class));
        }
        return guilds;
    }

    public List<Guild> getGuilds(String before, String after, Integer limit) {
        JsonElement jsonElement = botApiAccess.request("GET /users/@me/guilds",
                Pair.of("before", before),
                Pair.of("after", after),
                Pair.of("limit", limit));


        ArrayList<Guild> guilds = new ArrayList<>();
        for (JsonElement element : jsonElement.getAsJsonArray()) {
            guilds.add(gson.fromJson(element, Guild.class));
        }
        return guilds;
    }
}
