package com.example.cshaoshao.litepalbase.utils;


import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by cshaoshao on 2017/3/10.
 */

public class NetworkUtils {
    public static String get_json(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            return responseData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getData(String url)
    {
        try {
            OkHttpClient okHttpClient=new OkHttpClient();
            RequestBody requestBody=new FormBody.Builder().build();
            Request request=new Request.Builder().url(url).post(requestBody).build();
            Response response=okHttpClient.newCall(request).execute();
            String responseData=response.body().string();
            return responseData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
