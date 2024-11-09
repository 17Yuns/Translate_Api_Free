package com.yiqiyun.translateapi.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.yiqiyun.translateapi.pojo.ResultData;
import com.yiqiyun.translateapi.service.BingService;
import com.yiqiyun.translateapi.untils.Bing;
import com.yiqiyun.translateapi.untils.LanguageMapping;
import com.yiqiyun.translateapi.untils.StorageHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 17Yuns
 */
@Slf4j
@Service
public class BingServiceImpl implements BingService {
    @Override
    public String translate(String text, String targetLang) {
        String[] ig = new String[]{
                StorageHashMap.getInstance().getData("bingIg"),
                StorageHashMap.getInstance().getData("bingKey"),
                StorageHashMap.getInstance().getData("bingToken")
        };
        String bingLang = LanguageMapping.getBingLang(targetLang);
        // 检查是否有数据为 null
        for (String param : ig) {
            if (param == null) {
                log.error("Required parameter is missing in StorageHashMap.");
            }
        }

        // 获取翻译结果
        JSONObject bingTranslate = Bing.processBingJson(Bing.getBingTranslate(text, bingLang, ig));

        // 检查返回的 JSON 对象是否为 null
        if (bingTranslate == null) {
            log.error("Bing Translate response is null.");
        }

        // 构造结果并返回
        ResultData resultData = new ResultData()
                .setCode(200)
                .setData(bingTranslate.getString("translatedText"))
                .setPinyin(bingTranslate.getString("transliteratedText"));

        return JSON.toJSONString(resultData);

    }
}
