package com.molean.tencent.channelbot;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Logger;

public class BotAccess {
    private final static String BASE_SANDBOX = "https://sandbox.api.sgroup.qq.com";
    private final static String BASE_PRODUCTION = "https://api.sgroup.qq.com";


    @Getter
    @Setter
    private String botAppId;
    @Getter
    @Setter
    private String token;
    @Getter
    @Setter
    @Nullable
    private String botSecret;
    @Getter
    @Setter
    private Boolean sandbox;
    @Getter
    private Logger logger;

    @Getter
    private String botName;

    public BotAccess(@NotNull String botAppId, @NotNull String token, @Nullable String botSecret, @NotNull Boolean sandbox) {
        this.botAppId = botAppId;
        this.token = token;
        this.botSecret = botSecret;
        this.sandbox = sandbox;
        setBotName(botAppId);
    }


    public void setBotName(String botName) {
        this.botName = botName;
        logger = Logger.getLogger(getLoggerNamespace());
    }

    public String getLoggerNamespace() {
        return "Bot-" + botName + "-" + this.hashCode() % 100;
    }

    public String getAuthorization() {
        return "Bot %s.%s".formatted(botAppId, token);
    }

    public String getUrlBase() {
        return sandbox ? BASE_SANDBOX : BASE_PRODUCTION;
    }

}
