package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Member;
import it.unimi.dsi.fastutil.Pair;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private BotApiAccess botApiAccess;

    private Gson gson;

    public MemberService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public List<Member> getGuildMembers(String guildId, String after, int limit) {
        JsonElement request = botApiAccess.request("GET /guilds/{guild}/members",
                Pair.of("guild", guildId),
                Pair.of("after", after),
                Pair.of("limit", limit)
        );
        List<Member> members = new ArrayList<>();
        for (JsonElement jsonElement : request.getAsJsonArray()) {
            Member member = gson.fromJson(jsonElement, Member.class);
            members.add(member);
        }
        return members;
    }

    public List<Member> getGuildMembers(String guildId) {
        ArrayList<Member> members = new ArrayList<>();
        while (true) {
            List<Member> guildMembers;
            if (members.isEmpty()) {
                guildMembers = getGuildMembers(guildId, "0", 400);
            }else{
                guildMembers = getGuildMembers(guildId, members.get(members.size() - 1).getUser().getId(), 400);
            }
            if (guildMembers.isEmpty()) {
                break;
            }else{
                members.addAll(guildMembers);
            }
        }
        return members;
    }


    public List<Member> getGuildMembersWithRole(String guildId, String roleId, String startIndex, int limit) {
        JsonElement request = botApiAccess.request("GET /guilds/{guild_id}/roles/{role_id}/members",
                Pair.of("guild_id", guildId),
                Pair.of("role_id", roleId),
                Pair.of("start_index", startIndex),
                Pair.of("limit", limit)
        );

        List<Member> members = new ArrayList<>();
        for (JsonElement jsonElement : request.getAsJsonObject().get("data").getAsJsonArray()) {
            Member member = gson.fromJson(jsonElement, Member.class);
            members.add(member);
        }
        return members;
    }


    public List<Member> getGuildMembersWithRole(String guildId, String roleId) {
        ArrayList<Member> members = new ArrayList<>();
        while (true) {
            List<Member> guildMembers;
            if (members.isEmpty()) {
                guildMembers = getGuildMembersWithRole(guildId,roleId, "0", 400);
            }else{
                guildMembers = getGuildMembersWithRole(guildId, roleId, members.get(members.size() - 1).getUser().getId(), 400);
            }
            if (guildMembers.isEmpty()) {
                break;
            }else{
                members.addAll(guildMembers);
            }
        }
        return members;
    }
    public Member getMemberById(String guildId, String userId) {
        JsonElement request = botApiAccess.request("GET /guilds/{guild}/members/{user}",
                Pair.of("guild", guildId),
                Pair.of("user", userId)
        );

        return gson.fromJson(request, Member.class);
    }


    public void deleteMember(String guildId, String userId,Boolean addBlackList,int deleteHistoryMsgAys) {
        botApiAccess.request("DELETE /guilds/{guild}/members/{user}",
                Pair.of("guild", guildId),
                Pair.of("user", userId),
                Pair.of("add_blacklist", deleteHistoryMsgAys),
                Pair.of("delete_history_msg_days", deleteHistoryMsgAys)
        );
    }
}
