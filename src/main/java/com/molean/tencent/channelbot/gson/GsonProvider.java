package com.molean.tencent.channelbot.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProvider {
    private static Gson gson;

    public static Gson gson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapterFactory(EnumIntTypeAdapterFactory.create())
                    .create();
        }
        return gson;
    }
}
