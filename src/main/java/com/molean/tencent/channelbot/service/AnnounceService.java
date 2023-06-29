package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Announces;
import com.molean.tencent.channelbot.post.CreateAnnounces;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;

public class AnnounceService {
    private final BotApiAccess botApiAccess;

    private final Gson gson;



    public AnnounceService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public Announces createAnnounces(String guildId, CreateAnnounces createAnnounces) {
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /guilds/{guild_id}/announces", Pair.of("guild_id", guildId));
        JsonElement request = botApiAccess.request(pair, createAnnounces);
        return gson.fromJson(request, Announces.class);
    }

    /**
     * 用于删除频道 guild_id 下指定 message_id 的全局公告。
     * @param guildId
     * @param messageId
     */
    public void deleteAnnounces(String guildId, String messageId) {
        botApiAccess.request("DELETE /guilds/{guild_id}/announces/{message_id}",
                Pair.of("guild_id", guildId),
                Pair.of("message_id", messageId));
    }
    /**
     * 用于删除频道 guild_id 下所有全局公告。
     * @param guildId
     */
    public void deleteAnnounces(String guildId) {
        deleteAnnounces(guildId, "all");
    }
}
