package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/*
users	array	用户对象，参考 UserCommand，会返回 id, username, avatar
cookie	string	分页参数，用于拉取下一页
is_end	bool	是否已拉取完成到最后一页，true代表完成
 */
@Data
public class ReactionUserList {
    private List<User> users;
    private String cookie;
    @SerializedName("is_end")
    private boolean isEnd;
}
