package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.PinsMessage;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;

public class PinsMessageService {
    private BotApiAccess botApiAccess;
    private Gson gson;

    public PinsMessageService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public PinsMessage createPinsMessage(String channelId, String messageId) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PUT /channels/{channel_id}/pins/{message_id}",
                Pair.of("channel_id", channelId),
                Pair.of("message_id", messageId)
        );

        JsonElement request = botApiAccess.request(pair, null);
        return gson.fromJson(request, PinsMessage.class);
    }

    public void deletePinsMessage(String channelId, String messageId) {
        botApiAccess.request("DELETE /channels/{channel_id}/pins/{message_id}",
                Pair.of("channel_id", channelId),
                Pair.of("message_id", messageId)
        );
    }

    public void deletePinsMessage(String channelId) {
        deletePinsMessage(channelId, "all");
    }

    public PinsMessage getChannelPinsMessage(String channelId) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/pins",
                Pair.of("channel_id", channelId)
        );
        return gson.fromJson(request, PinsMessage.class);

    }
}
