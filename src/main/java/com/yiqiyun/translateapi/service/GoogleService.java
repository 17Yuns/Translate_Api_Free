package com.yiqiyun.translateapi.service;

/**
 * @author 17Yuns
 */

public interface GoogleService {
    String translate(String text, String targetLang);

    String translateOrigin(String text, String targetLang);
}
