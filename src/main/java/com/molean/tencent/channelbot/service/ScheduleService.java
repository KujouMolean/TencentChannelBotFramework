package com.molean.tencent.channelbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.molean.tencent.channelbot.BotApiAccess;
import com.molean.tencent.channelbot.entity.Schedule;
import com.molean.tencent.channelbot.post.CreateSchedule;
import com.molean.tencent.channelbot.post.UpdateSchedule;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ScheduleService {
    private BotApiAccess botApiAccess;
    private Gson gson;

    public ScheduleService(BotApiAccess botApiAccess, Gson gson) {
        this.botApiAccess = botApiAccess;
        this.gson = gson;
    }

    public List<Schedule> getChannelSchedules(String channelId, String since) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/schedules",
                Pair.of("channel_id", channelId),
                Pair.of("since", since));
        ArrayList<Schedule> schedules = new ArrayList<>();
        for (JsonElement jsonElement : request.getAsJsonArray()) {
            schedules.add(gson.fromJson(jsonElement, Schedule.class));
        }
        return schedules;
    }

    public Schedule getChannelScheduleById(String channelId, String scheduleId) {
        JsonElement request = botApiAccess.request("GET /channels/{channel_id}/schedules/{schedule_id}",
                Pair.of("channel_id", channelId),
                Pair.of("schedule_id", scheduleId));
        return gson.fromJson(request, Schedule.class);
    }

    public Schedule createSchedule(String channelId, CreateSchedule createSchedule) {
        Pair<String, URI> pair = botApiAccess.resolveURI("POST /channels/{channel_id}/schedules",
                Pair.of("channel_id", channelId));
        JsonElement request = botApiAccess.request(pair, channelId);
        return gson.fromJson(request, Schedule.class);
    }

    public Schedule updateSchedule(String channelId,String scheduleId, UpdateSchedule updateSchedule) {
        Pair<String, URI> pair = botApiAccess.resolveURI("PATCH /channels/{channel_id}/schedules/{schedule_id}",
                Pair.of("channel_id", channelId),
                Pair.of("schedule_id", scheduleId));
        JsonElement request = botApiAccess.request(pair, channelId);
        return gson.fromJson(request, Schedule.class);
    }

    public void deleteSchedule(String channelId, String scheduleId) {
        botApiAccess.request("DELETE /channels/{channel_id}/schedules/{schedule_id}", Pair.of("channel_id", channelId),
                Pair.of("schedule_id", scheduleId));
    }
}
