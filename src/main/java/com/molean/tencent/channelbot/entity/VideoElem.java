package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
third_url	string	第三方视频文件链接
 */
@Data
public class VideoElem {
    @SerializedName("third_url")
    private String thirdUrl;
}
