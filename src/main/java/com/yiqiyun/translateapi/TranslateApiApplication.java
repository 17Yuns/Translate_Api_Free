package com.yiqiyun.translateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 17Yuns
 */
@SpringBootApplication
@EnableScheduling
public class TranslateApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TranslateApiApplication.class, args);
    }

}
