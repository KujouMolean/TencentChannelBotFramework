package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
url	string	链接地址
display_text	string	链接显示文本
 */
@Data
public class UrlInfo {
    private String url;
    @SerializedName("display_text")
    private String displayText;

}
