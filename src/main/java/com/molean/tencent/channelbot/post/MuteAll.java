package com.molean.tencent.channelbot.post;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
mute_end_timestamp	string	禁言到期时间戳，绝对时间戳，单位：秒（与 mute_seconds 字段同时赋值的话，以该字段为准）
mute_seconds	string	禁言多少秒（两个字段二选一，默认以 mute_end_timestamp 为准）
#
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MuteAll extends AbstractMute {

}
