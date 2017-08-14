package com.daxueit.springmvc.service.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/13.
 */
@Service
public class DemoService {
    @Value("DemoService.testValue")
    private String testValue;

    public DemoService(){
        this.testValue="null";
        System.out.println("DemoService构造函数");
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}
