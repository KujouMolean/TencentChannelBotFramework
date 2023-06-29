package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
url	        string	架平图片链接
width	    uint32	图片宽度
height	    uint32	图片高度
image_id	string	图片ID
#
 */
@Data
public class PlatImage {
    private String url;
    private int width;
    private int height;
    @SerializedName("image_id")
    private String imageId;

}
