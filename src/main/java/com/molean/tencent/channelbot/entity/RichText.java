package com.molean.tencent.channelbot.entity;

import lombok.Data;

import java.util.List;

@Data
public class RichText {
    private List<Paragraph> paragraphs;
}
