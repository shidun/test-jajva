package com.imooc.testjava.controller.designPattern.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : shidun
 * @date : 2019/12/17
 */
public class ContainerSingleton {
    private static Map<String, Object> objectMap = new HashMap<>();

    public static void putInstance(String key, Object object){
        if (StringUtils.isNotBlank(key) && object != null) {
            if (objectMap.containsKey(key)) {
                objectMap.put(key, object);
            }
        }
    }

    public static Object getInstance(String key){
        return objectMap.get(key);
    }


}
