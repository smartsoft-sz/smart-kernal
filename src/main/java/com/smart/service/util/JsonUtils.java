package com.smart.service.util;

import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

/**
 */
public class JsonUtils {
  public static String toJson(Object obj) {
    return WxMpGsonBuilder.create().toJson(obj);
  }
}
