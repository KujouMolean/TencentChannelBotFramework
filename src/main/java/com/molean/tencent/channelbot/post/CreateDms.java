package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
recipient_id	string	接收者 id
source_guild_id	string	源频道 id
#
 */
@Data
public class CreateDms {
    @SerializedName("recipientId")
    private String recipientId;
    @SerializedName("sourceGuildId")
    private String sourceGuildId;
}
