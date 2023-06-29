package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Channel;
import com.molean.tencent.channelbot.entity.Role;
import com.molean.tencent.channelbot.post.CreateRole;
import com.molean.tencent.channelbot.post.UpdateRole;
import it.unimi.dsi.fastutil.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RoleService {

    private BotApiAccess botApiAccess;
    private Gson gson;

    public RoleService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public List<Role> getRoles(String guildId) {
        JsonElement request = botApiAccess.request("GET /guilds/{guild}/roles", Pair.of("guild", guildId));
        List<Role> roles = new ArrayList<>();
        for (JsonElement jsonElement : request.getAsJsonObject().get("roles").getAsJsonArray()) {
            roles.add(gson.fromJson(jsonElement, Role.class));
        }
        return roles;
    }

    public Role createRole(String guildId, CreateRole createRole) {
        JsonElement request = botApiAccess.request("POST /guilds/{guild}/roles", createRole, Pair.of("guild", guildId));
        JsonElement role = request.getAsJsonObject().get("role");
        return gson.fromJson(role, Role.class);
    }

    public Role updateRole(String guildId, String roleId, UpdateRole updateRole) {

        JsonElement request = botApiAccess.request("PATCH /guilds/{guild}/roles/{role}", updateRole,
                Pair.of("guild", guildId),
                Pair.of("role", roleId));

        JsonElement role = request.getAsJsonObject().get("role");
        return gson.fromJson(role, Role.class);
    }

    public void delete(String guildId, String roleId) {
        botApiAccess.request("DELETE /guilds/%s/roles/%s".formatted(guildId, roleId));
    }

    public void addMember(String guildId, String userId, String roleId, @Nullable Channel channel) {
        botApiAccess.request("PUT /guilds/{guild}/members/{user}/roles/{role}", channel,
                Pair.of("guild", guildId),
                Pair.of("user", userId),
                Pair.of("role", roleId)
        );

    }

    public void deleteMember(String guildId, String userId, String roleId, @Nullable Channel channel) {
        botApiAccess.request("DELETE /guilds/{guild}/members/{user}/roles/{role}", channel,
                Pair.of("guild", guildId),
                Pair.of("user", userId),
                Pair.of("role", roleId)
        );
    }
}
