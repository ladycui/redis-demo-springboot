package com.example.demo.service;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Cui Yanna on 2019/6/3
 */

public class Okhttp {
    public static void main(String[] args) {
//        getRequest();
//        postRequest();

        try {
            String res = run();
            System.out.println("response: " + res);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String run() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://www.baidu.com";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private static void postRequest() {
        //post
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("mb", "1000000");
        builder.add("pwd", "12345");
        String url = "";
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    private static void getRequest() {
        //get
        Request request = new Request.Builder().url("https://www.baidu.com").build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().toString();
                System.out.println("get: " + res);
            }
        });
    }


}
