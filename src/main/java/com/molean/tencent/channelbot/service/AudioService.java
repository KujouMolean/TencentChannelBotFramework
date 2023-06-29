package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.AudioControl;
import com.molean.tencent.channelbot.entity.Empty;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;

public class AudioService {
    private final BotApiAccess botApiAccess;
    private final Gson gson;

    public AudioService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public Empty postAudioControl(String channelId, AudioControl audioControl) {
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /channels/{channel_id}/audio",
                Pair.of("channel_id", channelId));


        JsonElement request = botApiAccess.request(pair, audioControl);

        return gson.fromJson(request, Empty.class);
    }

    public Empty onMic(String channelId) {
        JsonElement request = botApiAccess.request("PUT /channels/{channel_id}/mic",
                Pair.of("channel_id", channelId));
        return gson.fromJson(request, Empty.class);
    }
    public Empty offMic(String channelId) {
        JsonElement request = botApiAccess.request("DELETE /channels/{channel_id}/mic",
                Pair.of("channel_id", channelId));
        return gson.fromJson(request, Empty.class);
    }
}
