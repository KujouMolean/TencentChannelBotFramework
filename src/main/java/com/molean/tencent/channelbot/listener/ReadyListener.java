package com.molean.tencent.channelbot.listener;

import com.google.common.eventbus.Subscribe;
import com.molean.tencent.channelbot.Bot;
import com.molean.tencent.channelbot.entity.User;
import com.molean.tencent.channelbot.event.ReadyEvent;
import com.molean.tencent.channelbot.event.ResumedEvent;

public class ReadyListener {
    private final Bot bot;

    public ReadyListener(Bot bot) {
        this.bot = bot;
    }


    @Subscribe
    public void on(ReadyEvent readyEvent) {
        User user = readyEvent.getUser();
        bot.getBotAccess().getLogger().info(user.toString());
        bot.getBotWebSocket().startHeartbeat(bot.getBotWebSocketListener().getHeartbeatInterval());
        bot.setUser(user);
        bot.getBotAccess().setBotName(user.getUsername());
        bot.setSession(readyEvent.getSessionId());
        bot.setVersion(readyEvent.getVersion());
        bot.getBotAccess().getLogger().info("Bot is available!");
        bot.setReady(true);

        //
    }

    public void init() {

    }

    @Subscribe
    public void on(ResumedEvent event) {
        bot.setReady(true);
    }
}
