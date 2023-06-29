package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.CreateThreadResult;
import com.molean.tencent.channelbot.entity.Thread;
import com.molean.tencent.channelbot.post.CreateThread;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ThreadService {
    private BotApiAccess botApiAccess;
    private Gson gson;

    public ThreadService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public List<Thread> getChannelThreads(String channelId) {

        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/threads",
                Pair.of("channel_id", channelId));
        ArrayList<Thread> threads = new ArrayList<>();
        for (JsonElement jsonElement : request.getAsJsonObject().get("threads").getAsJsonArray()) {
            Thread thread = gson.fromJson(jsonElement, Thread.class);
            threads.add(thread);
        }
        return threads;
    }


    public Thread getThreadById(String channelId, String threadId) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/threads/{thread_id}",
                Pair.of("channel_id", channelId),
                Pair.of("thread_id", threadId));
        return gson.fromJson(request.getAsJsonObject().get("thread"), Thread.class);
    }

    public CreateThreadResult createThread(String channelId, CreateThread createThread) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PUT /channels/{channel_id}/threads",
                Pair.of("channel_id", channelId));
        JsonElement request = botApiAccess.request(pair, createThread);
        return gson.fromJson(request, CreateThreadResult.class);
    }

    public void deleteThread(String channelId) {
        botApiAccess.request("DELETE /channels/{channel_id}/threads/{thread_id}",
                Pair.of("channel_id", channelId));
    }

}
