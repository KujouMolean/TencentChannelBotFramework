package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*id	string	身份组ID
name	string	名称
color	uint32	ARGB的HEX十六进制颜色值转换后的十进制数值
hoist	uint32	是否在成员列表中单独展示: 0-否, 1-是
number	uint32	人数
member_limit	uint32	成员上限
 */
@Data
public class Role {
    private String id;
    private String name;
    private Integer color;
    private Integer hoist;
    private Integer number;
    @SerializedName("member_limit")
    private Integer memberLimit;

}
