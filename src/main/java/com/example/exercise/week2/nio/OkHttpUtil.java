package com.example.exercise.week2.nio;

import lombok.SneakyThrows;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpUtil {

    /**
     * okhttp get同步请求
     *
     * @param url
     * @return
     */
    @SneakyThrows
    public static String get(String url) {
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().get().url(url).build();
            Call call = client.newCall(request);
            response = call.execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }

        System.out.println("ok http execute error");
        return null;
    }

    public static void main(String[] args) {
        String url = "http://localhost:9901";
        String result = OkHttpUtil.get(url);
        System.out.println(result);
    }
}
