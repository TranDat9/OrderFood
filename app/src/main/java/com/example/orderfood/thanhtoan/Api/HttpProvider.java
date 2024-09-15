package com.example.orderfood.thanhtoan.Api;

import okhttp3.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class HttpProvider {
    private static final OkHttpClient client = new OkHttpClient();

    public static JSONObject sendPost(String url, RequestBody formBody) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .post(formBody)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            return new JSONObject(responseBody);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}