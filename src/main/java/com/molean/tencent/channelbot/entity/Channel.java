package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.gson.IgnoreEnumIntConvert;
import lombok.Data;

@Data
public class Channel {
    /*
        字段名	类型	描述
        id	string	子频道 id
        guild_id	string	频道 id
        name	string	子频道名
        type	int	子频道类型 ChannelType
        sub_type	int	子频道子类型 ChannelSubType
        position	int	排序值，具体请参考 有关 position 的说明
        parent_id	string	所属分组 id，仅对子频道有效，对 子频道分组（ChannelType=4） 无效
        owner_id	string	创建人 id
        private_type	int	子频道私密类型 PrivateType
        speak_permission	int	子频道发言权限 SpeakPermission
        application_id	string	用于标识应用子频道应用类型，仅应用子频道时会使用该字段，具体定义请参考 应用子频道的应用类型
        permissions	string	用户拥有的子频道权限 Permissions

     */

    public enum ChannelType {
        /*
            值	描述
            0	文字子频道
            1	保留，不可用
            2	语音子频道
            3	保留，不可用
            4	子频道分组
            10005	直播子频道
            10006	应用子频道
            10007	论坛子频道
         */
        @SerializedName("0")
        TEXT,
        @SerializedName("1")
        RESERVED_1,
        @SerializedName("2")
        VOICE,
        @SerializedName("3")
        RESERVED_3,
        @SerializedName("4")
        GROUP,
        @SerializedName("5")
        LIVE_2, // use in AUDIO_OR_LIVE_CHANNEL_MEMBER_ENTER
        @SerializedName("10005")
        LIVE,
        @SerializedName("10006")
        APPLICATION,
        @SerializedName("10007")
        FORUM,
    }

    public enum ChannelSubType {
        /*
            值	描述
            0	闲聊
            1	公告
            2	攻略
            3	开黑
         */
        @SerializedName("0")
        CHAT,
        @SerializedName("1")
        ANNOUNCEMENT,
        @SerializedName("2")
        INTRODUCTION,
        @SerializedName("3")
        TEAM_VOICE,
    }

    public enum PrivateType {
        /*
            值	描述
            0	公开频道
            1	群主管理员可见
            2	群主管理员+指定成员，可使用 修改子频道权限接口 指定成员
         */
        @SerializedName("0")
        PUBLIC,
        @SerializedName("1")
        OPERATORS_ONLY,
        @SerializedName("2")
        TARGET_MEMBERS,
    }

    public enum SpeakPermission {
        /*
            0	无效类型
            1	所有人
            2	群主管理员+指定成员，可使用 修改子频道权限接口 指定成员
         */
        @SerializedName("0")
        INVALID,
        @SerializedName("1")
        EVERYONE,
        @SerializedName("2")
        TARGET_MEMBERS,
    }

    @IgnoreEnumIntConvert
    public enum ApplicationType {
        /*
            1000000	王者开黑大厅
            1000001	互动小游戏
            1000010	腾讯投票
            1000051	飞车开黑大厅
            1000050	日程提醒
            1000070	CoDM 开黑大厅
            1010000	和平精英开黑大厅
         */

        @SerializedName("1000000")
        AOV_TEAM_VOICE,
        @SerializedName("1000001")
        INTERACTIVE_MINIGAME,
        @SerializedName("1000010")
        TENCENT_VOTE,
        @SerializedName("1000051")
        QQ_SPEED_TEAM_VOICE,
        @SerializedName("1000050")
        SCHEDULE_NOTICE,
        @SerializedName("1000070")
        CoDM_TEAM_VOICE,
        @SerializedName("1010000")
        GOP_TEAM_VOICE,
    }


    private String id;
    @SerializedName("guild_id")
    private String guildId;
    private String name;
    private ChannelType type;
    @SerializedName("sub_type")
    private Integer usbType;
    private Integer position;
    private String parent_id;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("private_type")
    private PrivateType privateType;
    @SerializedName("speak_permission")
    private SpeakPermission speakPermission;
    @SerializedName("application_id")
    private ApplicationType applicationType;
    private String permissions;
}
