package com.mange.activity.service.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by lbm on 2017/11/15
 * @author lbm
 * 定时任务
 */
@Component
@EnableScheduling
@Slf4j
public class HellowScheduler {

    @Scheduled(cron = "0 0/15 * * * ?")
    public void hellow(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("time task hellow ！ "+df.format(new Date()));
    }
}
