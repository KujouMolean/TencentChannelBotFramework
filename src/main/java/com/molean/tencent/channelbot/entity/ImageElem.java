package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ImageElem {
    @SerializedName("third_url")
    private String thirdUrl;
    @SerializedName("width_percent")
    private String widthPercent;
}
