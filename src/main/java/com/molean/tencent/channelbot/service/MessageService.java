package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Message;
import com.molean.tencent.channelbot.post.CreateArk;
import com.molean.tencent.channelbot.post.CreateMessage;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;

public class MessageService {
    private BotApiAccess botApiAccess;
    private Gson gson;

    public MessageService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public Message getMessageById(String channelId, String messageId) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/messages/{message_id}",
                Pair.of("channel_id", channelId),
                Pair.of("message_id", messageId)
        );
        return gson.fromJson(request.getAsJsonObject().get("message"), Message.class);
    }

    public Message createMessage(String channelId, CreateMessage createMessage) {
        if (createMessage.getContent() != null) {
            createMessage.setContent(createMessage.getContent().replaceAll("@all", "@_all"));
            createMessage.setContent(createMessage.getContent().replaceAll("@everyone", "@_everyone"));
        }
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /channels/{channel_id}/messages",
                Pair.of("channel_id", channelId));
        JsonElement request = botApiAccess.request(pair, createMessage);
        return gson.fromJson(request, Message.class);
    }

    public void deleteMessage(String channelId, String messageId, boolean hideTip) {
        botApiAccess.request("DELETE /channels/{channel_id}/messages/{message_id}",
                Pair.of("hidetip", hideTip),
                Pair.of("channel_id", channelId),
                Pair.of("message_id", messageId));
    }

    public Message createArk(String channelId, CreateArk createArk) {
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /channels/{channel_id}/messages",
                Pair.of("channel_id", channelId));
        JsonElement request = botApiAccess.request(pair, createArk);
        return gson.fromJson(request, Message.class);
    }


    public void replyMessage(Message message, String content) {
        CreateMessage createMessage = new CreateMessage();
        createMessage.setContent(content);
        createMessage.setMsgId(message.getId());
        createMessage(message.getChannelId(), createMessage);
    }
}
