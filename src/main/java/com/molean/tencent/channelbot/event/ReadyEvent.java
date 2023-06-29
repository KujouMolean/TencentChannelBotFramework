package com.molean.tencent.channelbot.event;

import com.google.gson.annotations.SerializedName;
import com.molean.tencent.channelbot.annotations.EventType;
import com.molean.tencent.channelbot.entity.User;
import lombok.Data;

import java.util.List;

@EventType("READY")
@Data
public class ReadyEvent {
    private Integer version;
    @SerializedName("session_id")
    private String sessionId;
    private User user;
    private List<Integer> shard;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getShard() {
        return shard;
    }

    public void setShard(List<Integer> shard) {
        this.shard = shard;
    }
}
