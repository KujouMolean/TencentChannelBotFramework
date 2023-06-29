package com.molean.tencent.channelbot.entity;

import lombok.Data;

@Data
public class MessageReaction {
    /*
    字段名	类型	描述
    user_id	string	用户ID
    guild_id	string	频道ID
    channel_id	string	子频道ID
    target	ReactionTarget	表态对象
    emoji	Emoji	表态所用表情
     */
    private String user_id;
    private String guild_id;
    private String channel_id;
    private ReactionTarget reactionTarget;
    private Emoji emoji;
}
