package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emoji {
    public enum EmojiType {
        @SerializedName("1") SYSTEM_EMOJI,
        @SerializedName("2") EMOJI_EMOJI,
    }

    private String id;
    private EmojiType type;

    @Expose
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("4", "[得意]");
        map.put("5", "[流泪]");
        map.put("8", "[睡]");
        map.put("9", "[大哭]");
        map.put("10", "[尴尬]");
        map.put("12", "[调皮]");
        map.put("14", "[微笑]");
        map.put("16", "[酷]");
        map.put("21", "[可爱]");
        map.put("23", "[傲慢]");
        map.put("24", "[饥饿]");
        map.put("25", "[困]");
        map.put("26", "[惊恐]");
        map.put("27", "[流汗]");
        map.put("28", "[憨笑]");
        map.put("29", "[悠闲]");
        map.put("30", "[奋斗]");
        map.put("32", "[疑问]");
        map.put("33", "[嘘]");
        map.put("34", "[晕]");
        map.put("38", "[敲打]");
        map.put("39", "[再见]");
        map.put("41", "[发抖]");
        map.put("42", "[爱情]");
        map.put("43", "[跳跳]");
        map.put("49", "[拥抱]");
        map.put("53", "[蛋糕]");
        map.put("60", "[咖啡]");
        map.put("63", "[玫瑰]");
        map.put("66", "[爱心]");
        map.put("74", "[太阳]");
        map.put("75", "[月亮]");
        map.put("76", "[赞]");
        map.put("78", "[握手]");
        map.put("79", "[胜利]");
        map.put("85", "[飞吻]");
        map.put("89", "[西瓜]");
        map.put("96", "[冷汗]");
        map.put("97", "[擦汗]");
        map.put("98", "[抠鼻]");
        map.put("99", "[鼓掌]");
        map.put("100", "[糗大了]");
        map.put("101", "[坏笑]");
        map.put("102", "[左哼哼]");
        map.put("103", "[右哼哼]");
        map.put("104", "[哈欠]");
        map.put("106", "[委屈]");
        map.put("109", "[左亲亲]");
        map.put("111", "[可怜]");
        map.put("116", "[示爱]");
        map.put("118", "[抱拳]");
        map.put("120", "[拳头]");
        map.put("122", "[爱你]");
        map.put("123", "[NO]");
        map.put("124", "[OK]");
        map.put("125", "[转圈]");
        map.put("129", "[挥手]");
        map.put("144", "[喝彩]");
        map.put("147", "[棒棒糖]");
        map.put("171", "[茶]");
        map.put("173", "[泪奔]");
        map.put("174", "[无奈]");
        map.put("175", "[卖萌]");
        map.put("176", "[小纠结]");
        map.put("179", "[doge]");
        map.put("180", "[惊喜]");
        map.put("181", "[骚扰]");
        map.put("182", "[笑哭]");
        map.put("183", "[我最美]");
        map.put("201", "[点赞]");
        map.put("203", "[托脸]");
        map.put("212", "[托腮]");
        map.put("214", "[啵啵]");
        map.put("219", "[蹭一蹭]");
        map.put("222", "[抱抱]");
        map.put("227", "[拍手]");
        map.put("232", "[佛系]");
        map.put("240", "[喷脸]");
        map.put("243", "[甩头]");
        map.put("246", "[加油抱抱]");
        map.put("262", "[脑阔疼]");
        map.put("264", "[捂脸]");
        map.put("265", "[辣眼睛]");
        map.put("266", "[哦哟]");
        map.put("267", "[头秃]");
        map.put("268", "[问号脸]");
        map.put("269", "[暗中观察]");
        map.put("270", "[emm]");
        map.put("271", "[吃瓜]");
        map.put("272", "[呵呵哒]");
        map.put("273", "[我酸了]");
        map.put("277", "[汪汪]");
        map.put("278", "[汗]");
        map.put("281", "[无眼笑]");
        map.put("282", "[敬礼]");
        map.put("284", "[面无表情]");
        map.put("285", "[摸鱼]");
        map.put("287", "[哦]");
        map.put("289", "[睁眼]");
        map.put("290", "[敲开心]");
        map.put("293", "[摸锦鲤]");
        map.put("294", "[期待]");
        map.put("297", "[拜谢]");
        map.put("298", "[元宝]");
        map.put("299", "[牛啊]");
        map.put("305", "[右亲亲]");
        map.put("306", "[牛气冲天]");
        map.put("307", "[喵喵]");
        map.put("314", "[仔细分析]");
        map.put("315", "[加油]");
        map.put("318", "[崇拜]");
        map.put("319", "[比心]");
        map.put("320", "[庆祝]");
        map.put("322", "[拒绝]");
        map.put("324", "[吃糖]");
        map.put("326", "[生气]");
        map.put("9728", "[晴天]");
        map.put("9749", "[咖啡]");
        map.put("9786", "[可爱]");
        map.put("10024", "[闪光]");
        map.put("10060", "[错误]");
        map.put("10068", "[问号]");
        map.put("127801", "[玫瑰]");
        map.put("127817", "[西瓜]");
        map.put("127822", "[苹果]");
        map.put("127827", "[草莓]");
        map.put("127836", "[拉面]");
        map.put("127838", "[面包]");
        map.put("127847", "[刨冰]");
        map.put("127866", "[啤酒]");
        map.put("127867", "[干杯]");
        map.put("127881", "[庆祝]");
        map.put("128027", "[虫]");
        map.put("128046", "[牛]");
        map.put("128051", "[鲸鱼]");
        map.put("128053", "[猴]");
        map.put("128074", "[拳头]");
        map.put("128076", "[好的]");
        map.put("128077", "[厉害]");
        map.put("128079", "[鼓掌]");
        map.put("128089", "[内衣]");
        map.put("128102", "[男孩]");
        map.put("128104", "[爸爸]");
        map.put("128147", "[爱心]");
        map.put("128157", "[礼物]");
        map.put("128164", "[睡觉]");
        map.put("128166", "[水]");
        map.put("128168", "[吹气]");
        map.put("128170", "[肌肉]");
        map.put("128235", "[邮箱]");
        map.put("128293", "[火]");
        map.put("128513", "[呲牙]");
        map.put("128514", "[激动]");
        map.put("128516", "[高兴]");
        map.put("128522", "[嘿嘿]");
        map.put("128524", "[羞涩]");
        map.put("128527", "[哼哼]");
        map.put("128530", "[不屑]");
        map.put("128531", "[汗]");
        map.put("128532", "[失落]");
        map.put("128536", "[飞吻]");
        map.put("128538", "[亲亲]");
        map.put("128540", "[淘气]");
        map.put("128541", "[吐舌]");
        map.put("128557", "[大哭]");
        map.put("128560", "[紧张]");
        map.put("128563", "[瞪眼]");

    }

    @Override
    public String toString() {
        return map.getOrDefault(id, "[表情-%s]".formatted(id));
    }

    public static Emoji getEmojiById(String id) {
        if (Integer.parseInt(id) < 1000) {
            return new Emoji(id + "", EmojiType.SYSTEM_EMOJI);
        } else {
            return new Emoji(id + "", EmojiType.EMOJI_EMOJI);
        }
    }

}
