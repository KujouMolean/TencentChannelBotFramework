package com.molean.tencent.channelbot;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.molean.isletopia.framework.ClassResolver;
import com.molean.isletopia.framework.ClassScanner;
import com.molean.tencent.channelbot.gson.GsonProvider;
import com.molean.tencent.channelbot.listener.ReadyListener;
import com.molean.tencent.channelbot.service.*;
import org.jetbrains.annotations.Nullable;

import java.net.http.HttpClient;

public class BotFactory {
    public static Bot createBot(BotAccess botAccess, @Nullable BotCommandMap botCommandMap, ClassResolver classResolver, ClassScanner classScanner) {
        try {
            BotRegistrationProvider.INSTANCE.init(classResolver, classScanner);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Bot bot = new Bot();

        HttpClient httpClient = HttpClient.newBuilder().build();
        Gson gson = GsonProvider.gson();

        bot.setBotAccess(botAccess);

        bot.setBotCommandMap(new DefaultBotCommandMap(bot));

        bot.setBotCommandPermission(new DefaultBotCommandPermission());
        EventBus eventBus = new EventBus("Bot-" + botAccess.getBotAppId());
        bot.setEventBus(eventBus);
        BotApiAccess botApiAccess = new BotApiAccess(botAccess, httpClient, gson);
        bot.setApiAccess(botApiAccess);

        BotWebSocketListener botWebSocketListener = new BotWebSocketListener(bot, gson);
        bot.setBotWebSocketListener(botWebSocketListener);
        BotWebSocket botWebSocket = new BotWebSocket(gson, bot, httpClient);
        bot.setBotWebSocket(botWebSocket);
        botWebSocket.reconnect(true);


        bot.getEventBus().register(new ReadyListener(bot));
        bot.setAnnounceService(new AnnounceService(botApiAccess, gson));
        bot.setApiPermissionService(new ApiPermissionService(botApiAccess, gson));
        bot.setAudioService(new AudioService(botApiAccess, gson));
        bot.setChannelPermissionService(new ChannelPermissionService(botApiAccess, gson));
        bot.setChannelService(new ChannelService(botApiAccess, gson));
        bot.setDmsService(new DmsService(botApiAccess, gson));
        bot.setGuildService(new GuildService(botApiAccess, gson));
        bot.setMemberService(new MemberService(botApiAccess, gson));
        bot.setMessageReactionService(new MessageReactionService(botApiAccess, gson));
        bot.setMessageService(new MessageService(botApiAccess, gson));
        bot.setMessageSettingService(new MessageSettingService(botApiAccess, gson));
        bot.setMuteService(new MuteService(botApiAccess, gson));
        bot.setPinsMessageService(new PinsMessageService(botApiAccess, gson));
        bot.setRoleService(new RoleService(botApiAccess, gson));
        bot.setScheduleService(new ScheduleService(botApiAccess, gson));
        bot.setThreadService(new ThreadService(botApiAccess, gson));
        bot.setUserService(new UserService(botApiAccess, gson));


        return bot;
    }
}
