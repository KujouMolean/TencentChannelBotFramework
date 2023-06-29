package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
url	string	架平图片链接
width	uint32	图片宽度
height	uint32	图片高度
video_id	string	视频ID
duration	uint32	视频时长
cover	PlatImage	视频封面图属性
 */
@Data
public class PlatVideo {
    private String url;
    private int width;
    private int height;
    @SerializedName("video_id")
    private String videoId;
    private int duration;
    private PlatImage cover;
}
