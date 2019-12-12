package com.imooc.testjava.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

//    public static String toJson(Object object) {
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();
//        Gson gson = gsonBuilder.create();
//        return gson.toJson(object);
//    }

    /**
     * 转换为json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            Gson gson = new Gson();
            return gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
