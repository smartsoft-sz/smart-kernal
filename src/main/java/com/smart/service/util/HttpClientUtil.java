package com.smart.service.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final CloseableHttpClient httpclient = HttpClients.createDefault();

    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            log.error(">>> 发送HttpGet请求失败", e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送HttpPost请求，参数为map
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String, String> map) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        httppost.setHeader("Content-type", "application/json;charset=UTF-8");
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity1 = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity1);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送不带参数的HttpPost请求
     * @param url
     * @return
     */
    public static String sendPost(String url) {
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //获取逆地址解析得到的地址
    public static String getUserAddr(String result) {
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject jsonResult =JSON.parseObject(jsonObject.getString("result"));
        String address = jsonResult.getString("address");
        return address;
    }

    public static void main(String[] args) {
/*        String result = sendGet("http://apis.map.qq.com/ws/distance/v1/?mode=walking&from=31.26249,120.63212&to=31.26249,120.63212&key=GVRBZ-ARZCP-5NEDQ-VEB4S-BANX7-4WFDL");
        JSONObject jsonObject = JSON.parseObject(result);
        System.out.println(result);
        JSONObject jsonResult =JSON.parseObject(jsonObject.getString("result"));
        JSONArray jsonArray =  JSON.parseArray(jsonResult.getString("elements"));
        JSONObject q = JSON.parseObject(jsonArray.get(0).toString());
        String distance =q.getString("distance");
        System.out.println(distance);*/
        String result = sendGet("http://apis.map.qq.com/ws/geocoder/v1/?location=31.26249,120.63212&key=GVRBZ-ARZCP-5NEDQ-VEB4S-BANX7-4WFDL");
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject jsonObject2 = JSON.parseObject(jsonObject.getString("result"));
        System.out.println(jsonObject2);
        String jsonObject3 = jsonObject2.getString("address");
        System.out.println(jsonObject3);
    }
}
