package com.smart.qrcde;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WEIXINController {

    private static Logger logger = LoggerFactory.getLogger(WEIXINController.class);

    // 临时二维码
    private final static String QR_SCENE = "QR_SCENE";
    // 永久二维码
    private final static String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
    // 永久二维码(字符串)
    private final static String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
    // 创建二维码
    private String create_ticket_path = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    // 通过ticket换取二维码
    private String showqrcode_path = "https://mp.weixin.qq.com/cgi-bin/showqrcode";


    /**
     * 获取access_token
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public String getAccessToken(String appid, String appsecret) {
        String result = HttpRequestUtil.getAccessToken(appid,appsecret);
        JSONObject jsonObject = JSONObject.fromObject(result);
        if (null != jsonObject) {
            try {
                result = jsonObject.getString("access_token");
            } catch (JSONException e) {
                logger.info("获取token失败 errcode:"+jsonObject.getInt("errcode") +",errmsg:"+ jsonObject.getString("errmsg"));
            }
        }
        return result;
    }

    /**
     * 创建临时带参数二维码
     * @param accessToken
     * @expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @param sceneId 场景Id
     * @return
     */
    public String createTempTicket(String accessToken, String expireSeconds, int sceneId) {
        WeiXinQRCode wxQRCode = null;

        TreeMap<String,String> params = new TreeMap<String,String>();
        params.put("access_token", accessToken);
        Map<String,Integer> intMap = new HashMap<String,Integer>();
        intMap.put("scene_id",sceneId);
        Map<String,Map<String,Integer>> mapMap = new HashMap<String,Map<String,Integer>>();
        mapMap.put("scene", intMap);
        //
        Map<String,Object> paramsMap = new HashMap<String,Object>();
        paramsMap.put("expire_seconds", expireSeconds);
        paramsMap.put("action_name", QR_SCENE);
        paramsMap.put("action_info", mapMap);
        String data = new Gson().toJson(paramsMap);
        data = HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,create_ticket_path,params,data);
        try {
            wxQRCode = new Gson().fromJson(data, WeiXinQRCode.class);
        } catch (JsonSyntaxException e) {
            wxQRCode = null;
            e.printStackTrace();
        }
        return wxQRCode==null?null:wxQRCode.getTicket();

    }

    /**
     * 创建永久二维码(数字)
     * @param accessToken
     * @param sceneId 场景Id
     * @return
     */
    public String createForeverTicket(String accessToken, int sceneId) {

        TreeMap<String,String> params = new TreeMap<String,String>();
        params.put("access_token", accessToken);
        //output data
        Map<String,Integer> intMap = new HashMap<String,Integer>();
        intMap.put("scene_id",sceneId);
        Map<String,Map<String,Integer>> mapMap = new HashMap<String,Map<String,Integer>>();
        mapMap.put("scene", intMap);
        //
        Map<String,Object> paramsMap = new HashMap<String,Object>();
        paramsMap.put("action_name", QR_LIMIT_SCENE);
        paramsMap.put("action_info", mapMap);
        String data = new Gson().toJson(paramsMap);
        data =  HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,create_ticket_path,params,data);
        WeiXinQRCode wxQRCode = null;
        try {
            wxQRCode = new Gson().fromJson(data, WeiXinQRCode.class);
        } catch (JsonSyntaxException e) {
            wxQRCode = null;
            e.printStackTrace();
        }
        return wxQRCode==null?null:wxQRCode.getTicket();
    }

    /**
     * 创建永久二维码(字符串)
     *
     * @param accessToken
     * @param sceneStr 场景str
     * @return
     */
    public String createForeverStrTicket(String accessToken, String sceneStr){
        TreeMap<String,String> params = new TreeMap<String,String>();
        params.put("access_token", accessToken);
        Map<String,String> intMap = new HashMap<String,String>();
        intMap.put("scene_str",sceneStr);
        Map<String,Map<String,String>> mapMap = new HashMap<String,Map<String,String>>();
        mapMap.put("scene", intMap);

        Map<String,Object> paramsMap = new HashMap<String,Object>();
        paramsMap.put("action_name", QR_LIMIT_STR_SCENE);
        paramsMap.put("action_info", mapMap);
        String data = new Gson().toJson(paramsMap);
        data =  HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,create_ticket_path,params,data);
        WeiXinQRCode wxQRCode = null;
        try {
            wxQRCode = new Gson().fromJson(data, WeiXinQRCode.class);
        } catch (JsonSyntaxException e) {
            wxQRCode = null;
        }
        return wxQRCode==null?null:wxQRCode.getTicket();
    }

    /**
     * 获取二维码ticket后，通过ticket换取二维码图片展示
     * @param ticket
     * @return
     */
    public String showQrcode(String ticket){
        Map<String,String> params = new TreeMap<String,String>();
        params.put("ticket", HttpRequestUtil.urlEncode(ticket, HttpRequestUtil.DEFAULT_CHARSET));
        try {
            showqrcode_path = HttpRequestUtil.setParmas(params,showqrcode_path,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showqrcode_path;
    }

    /**
     * 获取二维码ticket后，通过ticket换取二维码图片
     * @param ticket
     * @param savePath  保存的路径,例如 F:\\test\test.jpg
     * @return      Result.success = true 表示下载图片下载成功
     */
    public WeiXinResult showQrcode(String ticket,String savePath) throws Exception{
        TreeMap<String,String> params = new TreeMap<String,String>();
        params.put("ticket", HttpRequestUtil.urlEncode(ticket, HttpRequestUtil.DEFAULT_CHARSET));
        WeiXinResult result = HttpRequestUtil.downMeaterMetod(params,HttpRequestUtil.GET_METHOD,showqrcode_path,savePath);
        return result;
    }

}
