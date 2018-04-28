package com.lyb.besttimer.annotation_api;

import java.util.HashMap;
import java.util.Map;

public class BindClassCenter {

    public static Map<String, Class<?>> bindMap = new HashMap<>();

    public static Class<?> findClass(String path) {
        return bindMap.get(path);
    }

}
