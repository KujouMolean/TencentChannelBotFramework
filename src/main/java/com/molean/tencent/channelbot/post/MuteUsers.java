package com.molean.tencent.channelbot.post;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MuteUsers extends AbstractMute{
    @SerializedName("user_ids")
    private List<String> userIds;
}
