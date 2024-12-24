package com.yiqiyun.translateapi.controller;

import com.yiqiyun.translateapi.pojo.RequestData;
import com.yiqiyun.translateapi.service.GoogleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 17Yuns
 */
@RestController
@RequestMapping("/Google")
@CrossOrigin(origins = "*")
public class GoogleTranslate {
    private final GoogleService googleService;

    public GoogleTranslate(GoogleService googleService) {
        this.googleService = googleService;
    }

    @PostMapping("/translate")
    public String translate(@RequestBody RequestData requestData) {
        return googleService.translate(requestData.getText(), requestData.getTarget_lang());
    }

    @GetMapping("/translate")
    public String translate() {
        return "请使用POST请求";
    }

    @PostMapping("/translate/Origin")
    public String translateOrigin(@RequestBody RequestData requestData) {
        return googleService.translateOrigin(requestData.getText(), requestData.getTarget_lang());
    }
}
