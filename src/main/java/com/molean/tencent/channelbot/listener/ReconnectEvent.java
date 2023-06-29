package com.molean.tencent.channelbot.listener;

import com.google.common.eventbus.Subscribe;
import com.molean.tencent.channelbot.event.socket.BotSocketCloseEvent;

public class ReconnectEvent {
    @Subscribe
    public void on(BotSocketCloseEvent event) {
        event.getBot().setReady(false);
        if (event.getBot().isDestroyed()) {
            event.getBot().getBotWebSocket().reconnect(false);

        }
    }
}
