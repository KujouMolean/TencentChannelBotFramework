package com.molean.tencent.channelbot;

import com.google.gson.reflect.TypeToken;
import com.molean.tencent.channelbot.gson.GsonProvider;
import lombok.Data;

import java.lang.reflect.Type;

@Data
public class Payload<D> {
    private Integer op;
    private D d;
    private Integer s;
    private String t;

    public static <T> Payload<T> parse(String string, Class<T> clazz) {
        Type type = TypeToken.getParameterized(Payload.class, clazz).getType();
        return GsonProvider.gson().fromJson(string, type);
    }
}

