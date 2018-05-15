package com.lyb.besttimer.annotation_api;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BindClassCenter {

    public static final String packageName = "com.lyb.besttimer.processor";

    private static Map<String, Class<?>> bindMap = new HashMap<>();

    public static Class<?> findClass(String path) {
        Class<?> aClass = bindMap.get(path);
        if (aClass == null) {
            String simpleName = path.replaceAll("/", "\\$\\$");
            try {
                IGetClass iGetClass = (IGetClass) Class.forName(BindClassCenter.packageName + "." + simpleName).getConstructor().newInstance();
                bindMap.put(path, aClass = iGetClass.getTargetClass());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return aClass;
    }

}
