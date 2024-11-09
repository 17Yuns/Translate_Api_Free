package com.yiqiyun.translateapi.task;

import com.yiqiyun.translateapi.untils.Bing;
import com.yiqiyun.translateapi.untils.StorageHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 在Spring Boot启动时执行的任务
 *
 * @author 17Yuns
 */

@Slf4j
@Component
public class StartUpTask implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] bingIg = Bing.getBingIg();
        StorageHashMap.getInstance().saveData("bingIg", bingIg[0]);
        StorageHashMap.getInstance().saveData("bingKey", bingIg[1]);
        StorageHashMap.getInstance().saveData("bingToken", bingIg[2]);
        log.info("Bing数据已更新");
    }
}
