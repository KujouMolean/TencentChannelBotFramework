package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Emoji;
import com.molean.tencent.channelbot.entity.ReactionUserList;
import com.molean.tencent.channelbot.entity.User;
import it.unimi.dsi.fastutil.Pair;

import java.util.ArrayList;
import java.util.List;

public class MessageReactionService {
    private BotApiAccess botApiAccess;
    private Gson gson;

    public MessageReactionService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public void createMessageReaction(String channelId, String messageId, Emoji emoji) {
        JsonElement request = botApiAccess.request("PUT /channels/{channel_id}/messages/{message_id}/reactions/{type}/{id}",
                Pair.of("channel_id", channelId),
                Pair.of("message_id", messageId),
                Pair.of("type", emoji.getType()),
                Pair.of("id", emoji.getId()));
    }
    public void deleteMessageReaction(String channelId, String messageId, Emoji emoji) {
        JsonElement request = botApiAccess.request("DELETE /channels/{channel_id}/messages/{message_id}/reactions/{type}/{id}",
                Pair.of("channel_id", channelId),
                Pair.of("message_id", messageId),
                Pair.of("type", emoji.getType()),
                Pair.of("id", emoji.getId()));
    }

    public ReactionUserList getUserList(String channelId, String messageId, Emoji emoji, String cookie, Integer limit) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/messages/{message_id}/reactions/{type}/{id}",
                Pair.of("channel_id", channelId),
                Pair.of("message_id", messageId),
                Pair.of("type", emoji.getType()),
                Pair.of("id", emoji.getId()),
                Pair.of("cookie", cookie),
                Pair.of("limit", limit));
        return gson.fromJson(request, ReactionUserList.class);
    }

    public List<User> getUserList(String channelId, String messageId, Emoji emoji) {
        ReactionUserList userList = getUserList(channelId, messageId, emoji, null, 50);
        ArrayList<User> users = new ArrayList<>();
        while (!userList.isEnd()) {
            users.addAll(userList.getUsers());
            String cookie = userList.getCookie();
            userList = getUserList(channelId, messageId, emoji, cookie, null);
        }
        return users;
    }

}
