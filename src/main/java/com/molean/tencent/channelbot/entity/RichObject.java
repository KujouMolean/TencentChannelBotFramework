package com.molean.tencent.channelbot.entity;

import lombok.Data;

/*
type	int	RichType 富文本类型
text_info	object	TextInfo 文本
at_info	object	AtInfo @ 内容
url_info	object	URLInfo 链接
emoji_info	object	EmojiInfo 表情
channel_info	object	ChannelInfo 提到的子频道
 */
@Data
public class RichObject {


    /*
    TEXT	1	普通文本
    AT	2	at信息
    URL	3	url信息
    EMOJI	4	表情
    CHANNEL	5	#子频道
    VIDEO	10	视频
    IMAGE	11	图片
    */
    public enum RichType{
        TEXT,
        AT,
        URL,
        EMOJI,
        CHANNEL,
        VIDEO,
        IMAGE
    }


    private RichType type;

}
