package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.post.MuteAll;
import com.molean.tencent.channelbot.post.MuteUser;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;

public class MuteService {
    private BotApiAccess botApiAccess;
    private Gson gson;

    public MuteService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public void muteAll(String guildId, MuteAll muteAll) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PATCH /guilds/{guild_id}/mute",
                Pair.of("guild_id", guildId));
        botApiAccess.request(pair, muteAll);
    }

    public void unmuteAll(String guildId) {
        MuteAll muteAll = new MuteAll();
        muteAll.setMuteSeconds("0");
        Pair<String, URI> pair = botApiAccess.resolveURI("PATCH /guilds/{guild_id}/mute",
                Pair.of("guild_id", guildId));
        botApiAccess.request(pair, muteAll);
    }


    public void muteUser(String guildId, String userId, MuteUser muteUser) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PATCH /guilds/{guild_id}/members/{user_id}/mute",
                Pair.of("guild_id", guildId),
                Pair.of("user_id", userId)
        );
        botApiAccess.request(pair, muteUser);
    }
    public void unmuteUser(String guildId, String userId) {
        MuteUser muteUser = new MuteUser();
        muteUser.setMuteSeconds("0");
        Pair<String, URI> pair = botApiAccess.resolveURI("PATCH /guilds/{guild_id}/members/{user_id}/mute",
                Pair.of("guild_id", guildId),
                Pair.of("user_id", userId)
        );
        botApiAccess.request(pair, muteUser);
    }

    public void muteUsers(String guildId, MuteUser muteUser) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PATCH /guilds/{guild_id}/mute",
                Pair.of("guild_id", guildId));
        botApiAccess.request(pair, muteUser);
    }
    public void unmuteUsers(String guildId,MuteUser muteUser) {
        muteUser.setMuteSeconds("0");
        muteUser.setMuteEndTimestamp(null);
        Pair<String, URI> pair = botApiAccess.resolveURI("PATCH /guilds/{guild_id}/mute",
                Pair.of("guild_id", guildId));
        botApiAccess.request(pair, muteUser);
    }
}
