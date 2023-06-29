package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.ApiPermission;
import com.molean.tencent.channelbot.entity.ApiPermissionDemand;
import com.molean.tencent.channelbot.post.CreatePermissionDemand;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ApiPermissionService {
    private final BotApiAccess botApiAccess;
    private final Gson gson;

    public ApiPermissionService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public List<ApiPermission> getGuildPermissions(String guildId) {
        JsonElement request = botApiAccess.request("GET /guilds/{guild_id}/api_permission",
                Pair.of("guild_id", guildId));
        ArrayList<ApiPermission> apiPermissions = new ArrayList<>();
        for (JsonElement jsonElement : request.getAsJsonObject().get("apis").getAsJsonArray()) {
            apiPermissions.add(gson.fromJson(jsonElement, ApiPermission.class));
        }
        return apiPermissions;
    }


    public ApiPermissionDemand createPermissionDemand(String guildId, CreatePermissionDemand createPermissionDemand) {
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /guilds/{guild_id}/api_permission/demand",
                Pair.of("guild_id", guildId));
        JsonElement request = botApiAccess.request(pair, createPermissionDemand);
        return gson.fromJson(request, ApiPermissionDemand.class);
    }
}
