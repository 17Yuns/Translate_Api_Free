package com.yiqiyun.translateapi.controller;

import com.yiqiyun.translateapi.pojo.RequestData;
import com.yiqiyun.translateapi.service.BingService;
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
@RequestMapping("/Bing")
@CrossOrigin(origins = "*")
public class BingTranslate {
    private final BingService bingService;


    public BingTranslate(BingService bingService) {
        this.bingService = bingService;
    }

    @PostMapping("/translate")
    public String translate(@RequestBody RequestData requestData) {
        return bingService.translate(requestData.getText(),requestData.getTarget_lang());
    }
    @GetMapping("/translate")
    public String translate() {
        return "请使用POST请求";
    }
}
