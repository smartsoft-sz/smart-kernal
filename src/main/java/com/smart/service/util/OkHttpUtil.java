package com.smart.service.util;

import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jinmeng Tang
 * @Date: Created in 2018/3/2 下午3:43
 */
@Component
public class OkHttpUtil {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    public static String sendPost(String url, String json) throws IOException {
        return OkHttpUtil.sendPost(url,json,new HashMap<String, String>());
    }

    public static String sendGet(String url) throws IOException {
        return OkHttpUtil.sendGet(url,new HashMap<String, String>());
    }

    public static String sendPut(String url, String json) throws IOException {
        return OkHttpUtil.sendPut(url,json,new HashMap<String, String>());
    }

    /**
     * 通过OkHttp发送post请求
     * @param url 请求地址
     * @param json 请求的内容
     * @param headers 请求头
     * @return
     * @throws IOException
     */
    public static String sendPost(String url, String json, Map<String,String> headers) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(body);
        if (headers.size() != 0) {
            for(Map.Entry<String, String> entry : headers.entrySet()){
                builder = builder.addHeader(entry.getKey(),entry.getValue());
            }
        }
        Request request = builder.build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     *
     * @param url 请求地址
     * @param headers 请求头
     * @return
     * @throws IOException
     */
    public static String sendGet(String url, Map<String,String> headers) throws IOException {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers.size() != 0) {
            for(Map.Entry<String, String> entry : headers.entrySet()){
                builder = builder.addHeader(entry.getKey(),entry.getValue());
            }
        }
        Request request = builder.build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String sendPut(String url, String json, Map<String,String> headers) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .put(body);
        if (headers.size() != 0) {
            for(Map.Entry<String, String> entry : headers.entrySet()){
                builder = builder.addHeader(entry.getKey(),entry.getValue());
            }
        }
        Request request = builder.build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
