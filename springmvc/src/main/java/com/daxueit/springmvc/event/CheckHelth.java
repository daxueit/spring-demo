package com.daxueit.springmvc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/13.
 */
@Service
public class CheckHelth {
    @Autowired
    DemoPublisher demoPublisher;

    @Scheduled(fixedDelay = 2000)
    public void checkHelth() {
        demoPublisher.publish(String.valueOf(System.currentTimeMillis()));
    }
}
