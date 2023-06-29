package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
font_bold	bool	加粗
italic	    bool	斜体
underline	bool	下划线
 */
@Data
public class TextProps {
    @SerializedName("font_bold")
    private Boolean fontBold;
    private Boolean italic;
    private Boolean underline;

}
