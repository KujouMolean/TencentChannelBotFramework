package com.molean.tencent.channelbot;

import com.google.common.eventbus.EventBus;
import com.molean.tencent.channelbot.entity.User;
import com.molean.tencent.channelbot.service.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bot {
    private BotAccess botAccess;

    private BotApiAccess apiAccess;
    private BotWebSocket botWebSocket;

    private BotWebSocketListener botWebSocketListener;

    private User user;

    private String session;

    private Integer version;

    private EventBus eventBus;

    private BotCommandMap botCommandMap;

    private BotCommandPermission botCommandPermission;

    private AnnounceService announceService;

    private ApiPermissionService apiPermissionService;

    private AudioService audioService;

    private ChannelPermissionService channelPermissionService;

    private ChannelService channelService;

    private DmsService dmsService;

    private GuildService guildService;

    private MemberService memberService;

    private MessageReactionService messageReactionService;

    private MessageService messageService;

    private MessageSettingService messageSettingService;

    private MuteService muteService;

    private PinsMessageService pinsMessageService;

    private RoleService roleService;

    private ScheduleService scheduleService;

    private ThreadService threadService;

    private UserService userService;
    private boolean destroyed = false;

    private boolean ready = false;

    protected Bot() {
    }

    public void destroy() {
        destroyed = true;
        botWebSocket.abort();
    }
}
