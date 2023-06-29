package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ParagraphProps {
    public enum Alignment {
        @SerializedName("0")
        ALIGNMENT_LEFT,
        @SerializedName("1")
        ALIGNMENT_MIDDLE,
        @SerializedName("2")
        ALIGNMENT_RIGHT,
    }
    private Alignment alignment;

}
