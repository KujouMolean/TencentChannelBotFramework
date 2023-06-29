package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Dms;
import com.molean.tencent.channelbot.entity.Message;
import com.molean.tencent.channelbot.post.CreateDms;
import com.molean.tencent.channelbot.post.CreateMessage;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;

public class DmsService {
    private BotApiAccess botApiAccess;
    private Gson gson;

    public DmsService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public Dms createDms(CreateDms createDms) {
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /users/@me/dms");
        JsonElement request = botApiAccess.request(pair, createDms);
        return gson.fromJson(request, Dms.class);
    }

    public Message createDmsMessage(String guildId, CreateMessage createMessage) {
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /dms/{guild_id}/messages",
                Pair.of("guild_id", guildId));
        JsonElement request = botApiAccess.request(pair, createMessage);
        return gson.fromJson(request, Message.class);
    }

    public void deleteDmsMessage(String guildId, String messageId, boolean hideTip) {
        botApiAccess.request("DELETE /dms/{guild_id}/messages/{message_id}",
                Pair.of("guild_id", guildId),
                Pair.of("message_id", messageId),
                Pair.of("hidetip", hideTip)
        );
    }
}
