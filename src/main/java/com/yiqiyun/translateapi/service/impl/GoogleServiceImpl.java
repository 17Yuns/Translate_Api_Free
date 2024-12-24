package com.yiqiyun.translateapi.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.yiqiyun.translateapi.pojo.ResultData;
import com.yiqiyun.translateapi.service.GoogleService;
import com.yiqiyun.translateapi.untils.Google;
import com.yiqiyun.translateapi.untils.LanguageMapping;
import org.springframework.stereotype.Service;

/**
 * @author 17Yuns
 */
@Service
public class GoogleServiceImpl implements GoogleService {
    @Override
    public String translate(String text, String targetLang) {
        // 判断目标语言是否为英语
        boolean isEn = "EN".equalsIgnoreCase(targetLang);
        String googleLang = LanguageMapping.getGoogleLang(targetLang);
        // 获取 Google 翻译结果
        String googleTranslateResponse = Google.getGoogleTranslate(text, googleLang);

        // 处理 Google 翻译的 JSON 响应
        JSONObject googleTranslate = Google.processGoogleJson(googleTranslateResponse, isEn);

        ResultData resultData = new ResultData()
                .setCode(200)
                .setData(googleTranslate.getString("translatedText"))
                .setPinyin(googleTranslate.getString("transliteratedText"));

        return JSON.toJSONString(resultData);

    }

    @Override
    public String translateOrigin(String text, String targetLang) {
        return Google.getGoogleTranslate(text, LanguageMapping.getGoogleLang(targetLang));
    }
}
