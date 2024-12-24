package com.yiqiyun.translateapi.untils;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.Headers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * Google翻译工具类
 *
 * @author 17Yuns
 */

public class Google {

    /**
     * 处理Google返回的json字符串，提取翻译后的文本和拼音
     *
     * @param jsonString Google原始翻译内容
     * @param isEn       是否为英文
     * @return JSONObject
     */
    public static JSONObject processGoogleJson(String jsonString, boolean isEn) {
        JSONObject json = new JSONObject();
        try {
            // 尝试解析 JSON 字符串为数组
            JSONArray jsonArray = JSON.parseArray(jsonString);
            if (jsonArray == null || jsonArray.isEmpty()) {
                json.put("translatedText", "Translation not found");
                json.put("transliteratedText", "Translation not found");
                return json;
            }

            // 获取第一个嵌套数组
            JSONArray firstArray = jsonArray.getJSONArray(0);
            if (firstArray == null || firstArray.isEmpty()) {
                json.put("translatedText", "Translation not found");
                json.put("transliteratedText", "Translation not found");
                return json;
            }

            // 获取第一个数组中的第二个元素的数组
            JSONArray secondArray = firstArray.getJSONArray(0);
            if (secondArray == null || secondArray.isEmpty()) {
                json.put("translatedText", "Translation not found");
                json.put("transliteratedText", "Translation not found");
                return json;
            }

            // 获取翻译文本
            String translatedText = secondArray.getString(0);
            if (translatedText == null) {
                translatedText = "Translation not found";
            }

            // 获取拼音
            String pinyin = null;
            if (isEn) {
                // 如果是英文，尝试从第二个数组中获取拼音
                JSONArray secondArrayPinyin = firstArray.getJSONArray(1);
                if (secondArrayPinyin != null && secondArrayPinyin.size() > 3) {
                    pinyin = secondArrayPinyin.getString(3);
                }
            } else {
                // 如果是其他语言，默认返回固定拼音
                pinyin = "Bù zhīchí";
            }

            // 如果没有拼音，给一个默认值
            if (pinyin == null) {
                pinyin = "No pinyin available";
            }

            // 设置返回的 JSON
            json.put("translatedText", translatedText);
            json.put("transliteratedText", pinyin);

        } catch (Exception e) {
            // 处理解析 JSON 出现的任何异常
            json.put("translatedText", "Error parsing response");
            json.put("transliteratedText", "Error parsing response");
        }

        return json;
    }


    /**
     * 获取Google翻译原始的内容
     *
     * @param text 需要翻译的内容
     * @param to   需要翻译的语言
     * @return 翻译后的json
     */
    public static String getGoogleTranslate(String text, String to) {
        final String[] result = {null};
        CountDownLatch latch = new CountDownLatch(1);
        HttpRequest httpRequest = new HttpRequest();
        String[] url = constructTranslateUrl("https://translate.s9y.in", to, getGoogleToken(text), text);
        Headers headers = Headers.of(
                "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36");
        httpRequest.sendGetRequest(url[1], headers, new HttpRequest.ResponseCallback() {
            @Override
            public void onResponse(String response) {
                result[0] = response;
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

        return result[0];
    }

    /**
     * 构造翻译请求 URL
     *
     * @param url     请求 URL
     * @param to      目标语言
     * @param tk      Google token
     * @param message 翻译内容
     * @return String[] 构造后的链接
     */
    public static String[] constructTranslateUrl(String url, String to, String tk, String message) {
        String[] urls = new String[2];
        urls[0] = url + "/translate_a/single?client=t&sl=auto&tl=" + to + "&hl=" + to + "&dt=bd&dt=ex&dt=ld&dt=md&dt=qc&dt=rw&dt=rm&dt=ss&dt=t&dt=at&ie=UTF-8&oe=UTF-8&source=sel&tk=" + tk + "&q=" + message;
        urls[1] = url + "/translate_a/single?client=gtx&dt=t&ie=UTF-8&oe=UTF-8&sl=auto&tl=" + to + "&q=" + message;
        return urls;
    }

    /**
     * 构造朗读请求链接
     *
     * @param url     Google翻译地址
     * @param to      目标语言
     * @param tk      Google翻译tk
     * @param message 需要翻译的语言
     * @return resultUrl 构造后的链接
     */
    public static String constructTranslateSpeak(String url, String to, String tk, String message) {
        return url + "/translate_tts?ie=UTF-8&client=t&prev=input&q=" + message + "&tl=" + to + "&total=1&idx=0&textlen=4&tk=" + tk;
    }

    /**
     * 获取Google翻译tk
     *
     * @param text 需要翻译的文本
     * @return tk
     */
    public static String getGoogleToken(String text) {
        String tk = "";
        try {
            tk = calculateToken(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    /**
     * 主要生成算法
     *
     * @return String
     */
    public static String calculateToken(String text) {

        long b = 406644L;
        long b1 = 3293161072L;
        String SALT_1 = "+-a^+6";
        String SALT_2 = "+-3^+b+-f";
        String d = text;
        List<Integer> e = new ArrayList<>();
        for (int f = 0, g = 0; g < d.length(); g++) {
            int m = charCodeAt(d, g);
            if (m < 128) {
                e.add(m);
            } else if (m < 2048) {
                e.add(m >> 6 | 192);
                e.add(m & 0x3F | 0x80);
            } else if (0xD800 == (m & 0xFC00) && g + 1 < d.length() && 0xDC00 == (charCodeAt(d, g + 1) & 0xFC00)) {
                //  that's pretty rare... (avoid ovf?)
                m = (byte) ((1 << 16) + ((m & 0x03FF) << 10) + (charCodeAt(d, ++g) & 0x03FF));
                e.add(m >> 18 | 0xF0);
                e.add(m >> 12 & 0x3F | 0x80);
                e.add(m & 0x3F | 0x80);
            } else {
                e.add(m >> 12 | 0xE0);
                e.add(m >> 6 & 0x3F | 0x80);
                e.add(m & 0x3F | 0x80);
            }
        }
        Long a1 = b;
        for (Integer integer : e) {
            a1 += integer;
            a1 = rL(a1, SALT_1);

        }

        a1 = rL(a1, SALT_2);

        a1 ^= b1;
        if (0 > a1) {
            a1 = (a1 & 2147483647L) + 2147483648L;
        }

        a1 = a1 % 1000000;
        return a1 + "." + (a1 ^ b);
    }

    private static long rL(long a, String seed) {
        for (int i = 0; i < seed.length() - 2; i += 3) {
            char c = seed.toCharArray()[i + 2];
            long d = (c >= 'a') ? ((int) c - 87) : Integer.parseInt(c + "");
            d = (seed.toCharArray()[i + 1] == '+') ? (rshift(a, d)) : (a << d);
            a = (seed.toCharArray()[i] == '+') ? (a + d & 4294967295L) : (a ^ d);
        }
        return a;
    }

    private static long rshift(long val, long n) {
        return (val >= 0) ? (val >> n) : (val + 0x100000000L) >> n;
    }

    private static int charCodeAt(String string, int index) {
        return Character.codePointAt(string, index);
    }
}
