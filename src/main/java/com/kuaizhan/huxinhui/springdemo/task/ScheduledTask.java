package com.kuaizhan.huxinhui.springdemo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xinhui on 16/2/1.
 */
@Component
public class ScheduledTask {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 150000)
    public void reportCurrentTime(){
        System.out.println("The Time now is " + dataFormat.format(new Date()));
    }
}
