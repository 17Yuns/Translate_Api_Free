package com.yiqiyun.translateapi.untils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bing翻译工具类
 *
 * @author 17Yuns
 */

public class Bing {

    /**
     * 处理bing返回的json字符串，提取翻译后的文本和拼音
     *
     * @param jsonString 输入的JSON字符串
     * @return 包含翻译后的文本和拼音的JSONObject
     */
    public static JSONObject processBingJson(String jsonString) {
        JSONObject json = new JSONObject();
        try {
            // 解析 JSON 字符串为 JSONArray
            JSONArray jsonArray = JSON.parseArray(jsonString);

            // 遍历 JSONArray 提取翻译后的文本和拼音
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);

                // 提取翻译后的文本 (translations[0].text)
                if (item.containsKey("translations")) {
                    JSONArray translations = item.getJSONArray("translations");
                    if (translations != null && translations.size() > 0) {
                        JSONObject translation = translations.getJSONObject(0);
                        String translatedText = translation.getString("text");
                        if (translatedText != null) {
                            json.put("translatedText", translatedText);
                        }
                    }
                }

                // 提取拼音文本
                String transliteratedText = null;
                if (item.containsKey("inputTransliteration")) {
                    transliteratedText = item.getString("inputTransliteration");
                } else if (item.containsKey("translations")) {
                    // 如果没有 inputTransliteration，但有 translations，则从 transliteration.text 中提取拼音
                    JSONArray translations = item.getJSONArray("translations");
                    if (translations != null && translations.size() > 0) {
                        JSONObject translation = translations.getJSONObject(0);
                        JSONObject transliteration = translation.getJSONObject("transliteration");
                        if (transliteration != null) {
                            transliteratedText = transliteration.getString("text");
                        }
                    }
                }

                // 如果拼音存在，加入到返回的 JSON 中
                if (transliteratedText != null) {
                    json.put("transliteratedText", transliteratedText);
                }

                // 一旦找到翻译文本和拼音，直接返回结果
                if (json.containsKey("translatedText") && json.containsKey("transliteratedText")) {
                    return json;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // 可根据需求处理异常，可能记录日志等
            json.put("error", "Failed to process Bing translation JSON.");
        }

        // 如果没有找到翻译或拼音，返回空的 JSON 或默认值
        if (!json.containsKey("translatedText")) {
            json.put("translatedText", "Translation not found");
        }
        if (!json.containsKey("transliteratedText")) {
            json.put("transliteratedText", "Transliteration not found");
        }

        return json;
    }


    /**
     * 获取bing翻译的ig参数
     *
     * @return String[] ig参数
     */
    public static String[] getBingIg() {
        CountDownLatch latch = new CountDownLatch(1);
        final String[] result = new String[3];
        HttpRequest httpRequest = new HttpRequest();
        String url = "https://cn.bing.com/translator/";
        Headers headers = Headers.of(
                "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36");
        httpRequest.sendGetRequest(url, headers, new HttpRequest.ResponseCallback() {
            @Override
            public void onResponse(String response) {
                Pattern r = Pattern.compile(",IG:\"(.*?)\",");
                Matcher m = r.matcher(response);
                if (m.find()) {
                    result[0] = m.group(1);
                }
                String regex = "var\\s+params_AbusePreventionHelper\\s*=\\s*\\[\\s*(\\d+),\\s*\"([^\"]+)\"";
                Pattern rs = Pattern.compile(regex);
                Matcher ms = rs.matcher(response);
                if (ms.find()) {
                    result[1] = ms.group(1);  // 数字部分
                    result[2] = ms.group(2);
                }
                latch.countDown();
            }

            @Override
            public void onFailure(IOException e) {
                result[0] = null;
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return result;
    }

    /**
     * 获取bing翻译的原始内容
     *
     * @param text 需要翻译的内容
     * @param to   翻译对应的语言参数
     * @return String 翻译后的未处理的内容
     */
    public static String getBingTranslate(String text, String to,String[] ig) {

        CountDownLatch latch = new CountDownLatch(1);
        final String[] resultResponse = new String[1];
        String url = "https://cn.bing.com/ttranslatev3?isVertical=1&&IG=" + ig[0] + "&IID=translator.5025.1";
        Headers headers = Headers.of(
                "user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36",
                "referer", "https://cn.bing.com/translator/",
                "origin", "https://cn.bing.com",
                "cookie", "MUID=096F420F0C72689723B74D660D0869AB; MUIDB=096F420F0C72689723B74D660D0869AB; _EDGE_V=1; SRCHD=AF=NOFORM; SRCHUID=V=2&GUID=4AA515596EB74801BC2212A2B99B705B&dmnchg=1; _SS=SID=118F574600DF62242683583D01F163BB; _TTSS_OUT=hist=WyJhZiIsImVuIl0=; _tarLang=default=en; btstkn=Ri2Gozn6GnnrscD5AGT0ykm4grRxenOXfloAsZnH9PucxJzHT%252Fwai5ui8TOq0QIK; _TTSS_IN=hist=WyJlbiIsImFmIiwiemgtSGFucyIsImF1dG8tZGV0ZWN0Il0=; SNRHOP=I=&TS=; SRCHUSR=DOB=20201106&T=1604735730000; _EDGE_S=F=1&SID=0F0E55C7A96F6A3314845ABCA82C6B51; SRCHHPGUSR=HV=1604735900&WTS=63740332530"
        );

        RequestBody formBody = new FormBody.Builder()
                .add("fromLang", "auto-detect")
                .add("text", text)
                .add("to", to)
                .add("key", ig[1])
                .add("token", ig[2])
                .add("tryFetchingGenderDebiasedTranslations", "true")
                .build();


        HttpRequest httpRequest = new HttpRequest();
        httpRequest.sendPostRequest(url, headers, formBody, new HttpRequest.ResponseCallback() {
            @Override
            public void onResponse(String result) {
                resultResponse[0] = result;
                latch.countDown();
            }

            @Override
            public void onFailure(IOException e) {
                resultResponse[0] = null;
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return resultResponse[0];
    }

}
