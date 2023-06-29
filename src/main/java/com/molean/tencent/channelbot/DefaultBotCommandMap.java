package com.molean.tencent.channelbot;

import com.google.common.eventbus.Subscribe;
import com.molean.tencent.channelbot.entity.Message;
import com.molean.tencent.channelbot.event.AtMessageCreateEvent;
import com.molean.tencent.channelbot.event.MessageCreateEvent;

import java.util.*;

public class DefaultBotCommandMap implements BotCommandMap{
    private final Map<String, BotCommandExecutor> commandHandlerMap = new HashMap<>();

    @Override
    public void registerCommand(String cmd, BotCommandExecutor executor) {
        this.commandHandlerMap.put(cmd.toLowerCase(Locale.ROOT), executor);
    }
    @Override
    public boolean isRegistered(String cmd) {
        return commandHandlerMap.containsKey(cmd.toLowerCase(Locale.ROOT));
    }


    private final Bot bot;

    public DefaultBotCommandMap(Bot bot) {
        this.bot = bot;
    }

    @Subscribe
    public void on(AtMessageCreateEvent event) {
        if (event.getContent() == null) {
            return;
        }
        String content = event.getContent().trim();
        if (content.startsWith("<@!%s>".formatted(bot.getUser().getId()))) {
            content = content.replaceFirst("<@!%s>".formatted(bot.getUser().getId()), "").trim();
        } else {
            return;
        }
        if (content.startsWith("/")) {
            content = content.substring(1);
        }
        onMessage(event, content);
    }

    @Subscribe
    public void on(MessageCreateEvent event) {
        if (event.getContent() == null) {
            return;
        }
        String content = event.getContent().trim();
        if (content.startsWith("/")) {
            content = content.substring(1);
            onMessage(event, content);
        }
    }

    public void onMessage(Message message, String content) {
        Scanner scanner = new Scanner(content);
        if (scanner.hasNext()) {
            String cmd = scanner.next();
            ArrayList<String> args = new ArrayList<>();
            while (scanner.hasNext()) {
                String arg = scanner.next();
                args.add(arg);
            }
            BotCommandExecutor botCommandExecutor = commandHandlerMap.get(cmd.toLowerCase(Locale.ROOT));
            if (botCommandExecutor == null) {
                return;
            }
            try {
                botCommandExecutor.execute(bot, message, cmd, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
