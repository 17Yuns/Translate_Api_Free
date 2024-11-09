package com.yiqiyun.translateapi.task;

import com.yiqiyun.translateapi.untils.Bing;
import com.yiqiyun.translateapi.untils.StorageHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author 17Yuns
 */

@Slf4j
@Component
public class ScheduledTask {

    // 使用 cron 表达式每天每小时执行一次
    @Scheduled(cron = "0 0 * * * ?")
    public void runEveryHourCron() {
        log.info("每小时执行一次更新Bing的数据");
        String[] bingIg = Bing.getBingIg();
        StorageHashMap.getInstance().saveData("bingIg", bingIg[0]);
        StorageHashMap.getInstance().saveData("bingKey", bingIg[1]);
        StorageHashMap.getInstance().saveData("bingToken", bingIg[2]);
    }
}
