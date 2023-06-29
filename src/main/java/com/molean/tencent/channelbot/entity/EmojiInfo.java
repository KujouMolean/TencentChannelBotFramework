package com.molean.tencent.channelbot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
id	string	表情id
type	string	表情类型
name	string	名称
url	string	链接
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EmojiInfo extends Emoji{
    private String name;
    private String url;

}
