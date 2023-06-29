package com.molean.tencent.channelbot;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import it.unimi.dsi.fastutil.Pair;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class BotApiAccess {
    private BotAccess botAccess;
    private HttpClient httpClient;
    private Gson gson;

    public BotApiAccess(BotAccess botAccess, HttpClient httpClient, Gson gson) {
        this.botAccess = botAccess;
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public URI getWSSUrI() throws Exception {
        JsonElement jsonElement = this.request(resolveURI("GET /gateway"), null);
        String url = jsonElement.getAsJsonObject().get("url").getAsString();
        return new URI(url);
    }

    @SafeVarargs
    public final Pair<String, URI> resolveURI(String api, Pair<String, Object>... pairs) {
        String[] split = api.split(" ");
        String method = split[0];
        String path = split[1];
        ArrayList<Pair<String, Object>> pairArrayList = new ArrayList<>(Arrays.asList(pairs));
        for (Pair<String, Object> pair : pairs) {
            if (pair.left() == null || pair.right() == null) {
                pairArrayList.remove(pair);
                continue;
            }

            if (path.contains("{" + pair.left() + "}")) {
                path = path.replaceAll("\\{" + pair.left() + "}", pair.right().toString());
                pairArrayList.remove(pair);
            }
        }

        String url = botAccess.getUrlBase() + path;
        Map<String, String> params = new HashMap<>();
        for (Pair<String, Object> pair : pairArrayList) {
            if (!path.contains("{" + pair.left() + "}")) {
                params.put(pair.left(), pair.right().toString());
            }
        }
        String uri;
        if (params.isEmpty()) {
            uri = url;
        }else{
            List<String> strings = params.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).toList();
            uri = url + "?" + String.join("&", strings);
        }
        return Pair.of(method, URI.create(uri));
    }

    @SafeVarargs
    public final JsonElement request(String api, Object object, Pair<String, Object>... pairs) {
        HttpResponse<String> send = null;
        try {
            Pair<String, URI> pair = resolveURI(api, pairs);
            String data = object == null ? "" : gson.toJson(object);

            botAccess.getLogger().info("Request url " + pair.right() + " by " + pair.left() + " with " + object);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(pair.right())
                    .header("Authorization", botAccess.getAuthorization())
                    .header("Content-Type", "application/json")
                    .method(pair.left(), HttpRequest.BodyPublishers.ofString(data))
                    .build();
            send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        errorHandler(send);
        return JsonParser.parseString(send.body());
    }

    @SafeVarargs
    public final JsonElement request(String api, Pair<String, Object>... pairs) {
        HttpResponse<String> send = null;
        try {
            Pair<String, URI> pair = resolveURI(api, pairs);
            botAccess.getLogger().info("Request url " + pair.right() + " by " + pair.left() + ".");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(pair.right())
                    .header("Authorization", botAccess.getAuthorization())
                    .header("Content-Type", "application/json")
                    .method(pair.left(), HttpRequest.BodyPublishers.noBody())
                    .build();
            send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        errorHandler(send);
        return JsonParser.parseString(send.body());
    }

    public final JsonElement request(Pair<String, URI> pair, Object object) {
        botAccess.getLogger().info("Request url " + pair.right() + " by " + pair.left() + " with " + object);
        HttpResponse<String> send = null;
        try {
            String data = gson.toJson(object);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(pair.right())
                    .header("Authorization", botAccess.getAuthorization())
                    .header("Content-Type", "application/json")
                    .method(pair.left(), HttpRequest.BodyPublishers.ofString(data))
                    .build();
            send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        errorHandler(send);

        return JsonParser.parseString(send.body());
    }

    public void errorHandler(HttpResponse<String> httpResponse) {
        if (httpResponse.statusCode() < 200 || httpResponse.statusCode() >= 400) {
            throw new RuntimeException(httpResponse.body());
        }
    }

}
