package com.yiqiyun.translateapi.untils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据存储工具类
 *
 * @author 17Yuns
 */
@SuppressWarnings("all")
public class StorageHashMap {

    // 使用 ConcurrentHashMap 存储数据
    private ConcurrentHashMap<String, String> dataMap = new ConcurrentHashMap<>();

    private static class SingletonHelper {
        private static final StorageHashMap INSTANCE = new StorageHashMap();
    }

    // 获取唯一实例
    public static StorageHashMap getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // 存储数据
    public void saveData(String key, String value) {
        dataMap.put(key, value);
    }

    // 获取数据
    public String getData(String key) {
        return dataMap.get(key);
    }

    // 删除数据
    public void removeData(String key) {
        dataMap.remove(key);
    }
}