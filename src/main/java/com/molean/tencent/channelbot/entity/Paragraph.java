package com.molean.tencent.channelbot.entity;

import lombok.Data;

import java.util.List;

/*
elems	Elem	元素列表
props	ParagraphProps	段落属性
 */
@Data
public class Paragraph {
    private List<Elem> elems;
    private ParagraphProps props;
}
