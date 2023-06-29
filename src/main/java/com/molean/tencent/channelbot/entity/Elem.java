package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
text	TextElem	文本元素
image	ImageElem	图片元素
video	VideoElem	视频元素
url	URLElem	URL元素
type	ElemType	元素类型
 */
@Data
public class Elem {
    public enum ElemType {
        // ELEM_TYPE_TEXT	1	文本
        // ELEM_TYPE_IMAGE	2	图片
        // ELEM_TYPE_VIDEO	3	视频
        // ELEM_TYPE_URL	4	URL
        @SerializedName("1")
        ELEM_TYPE_TEXT,
        @SerializedName("2")
        ELEM_TYPE_IMAGE,
        @SerializedName("3")
        ELEM_TYPE_VIDEO,
        @SerializedName("4")
        ELEM_TYPE_URL,
    }

    private TextElem text;
    private ImageElem image;
    private VideoElem video;
    private UrlElem url;
    private ElemType type;
}
