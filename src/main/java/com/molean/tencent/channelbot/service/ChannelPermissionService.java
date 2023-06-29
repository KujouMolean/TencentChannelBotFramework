package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.ChannelPermission;
import com.molean.tencent.channelbot.post.UpdateRoleChannelPermission;
import com.molean.tencent.channelbot.post.UpdateUserChannelPermission;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;

public class ChannelPermissionService {
    private BotApiAccess botApiAccess;

    private Gson gson;

    public ChannelPermissionService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public ChannelPermission getUserChannelPermission(String channelId, String userId) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/members/{user_id}/permissions",
                Pair.of("channel_id", channelId),
                Pair.of("user_id", userId));
        return gson.fromJson(request, ChannelPermission.class);
    }

    public void updateChannelPermission(String channelId, String userId, UpdateUserChannelPermission updateUserChannelPermissionm) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PUT /channels/{channel_id}/members/{user_id}/permissions",
                Pair.of("channel_id", channelId),
                Pair.of("user_id", userId));
        botApiAccess.request(pair, updateUserChannelPermissionm);
    }

    public ChannelPermission getRoleChannelPermission(String channelId, String roleId) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/roles/{role_id}/permissions",
                Pair.of("channel_id", channelId),
                Pair.of("role_id", roleId));
        return gson.fromJson(request, ChannelPermission.class);
    }

    public void updateRoleChannelPermission(String channelId, String roleId, UpdateRoleChannelPermission updateRoleChannelPermission) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PUT /channels/{channel_id}/roles/{role_id}/permissions",
                Pair.of("channel_id", channelId),
                Pair.of("role_id", roleId));
        botApiAccess.request(pair, updateRoleChannelPermission);
    }

}
