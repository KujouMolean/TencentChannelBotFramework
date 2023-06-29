package com.molean.tencent.channelbot.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ChannelPermission {
    /*
    channel_id	string	子频道 id
    user_id/role_id	string	用户 id 或 身份组 id，只会返回其中之一
    permissions	string	用户拥有的子频道权限
     */

    public enum Permission{
        VIEW(1),MANAGE(1<<1),CHAT(1<<2), LIVE(1 << 3),;

        private final long val;
        Permission(long val) {
            this.val = val;
        }

        public long getVal() {
            return val;
        }
    }

    @SerializedName("channel_id")
    private String channelId;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("role_id")
    private String roleId;
    @SerializedName("permissions")
    private String permissions;

    public void addPermission(Permission permission) {
        long x = (Long.parseLong(permissions));
        permissions = "" + (x | permission.getVal());
    }

    public void removePermission(Permission permission) {
        long x = (Long.parseLong(permissions));
        permissions = "" + (x & (~permission.getVal()));
    }

    public boolean hasPermission(Permission permission) {
        return ((Long.parseLong(permissions) & permission.getVal()) > 0);
    }
}
