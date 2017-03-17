package pers.wzs.demo.okhttp;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by wangzhongshan on 2017/3/17.
 */
public class OkhttpDemo {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();

    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String post(String url, String json) throws IOException {
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
//        String response = run("https://www.baidu.com");
        String response = post("https://www.baidu.com","{name:wzs}");
        System.out.println(response);
    }
}
