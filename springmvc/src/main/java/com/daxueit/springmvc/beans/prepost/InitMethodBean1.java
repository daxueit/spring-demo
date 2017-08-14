package com.daxueit.springmvc.beans.prepost;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2017/8/13.
 */
@Component
public class InitMethodBean1 {
    @PostConstruct
    public void init(){
        System.out.println("InitMethodBean1.init()");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("InitMethodBean1.destroy()");
    }

    public InitMethodBean1(){
        System.out.println("InitMethodBean1构造函数");
    }
}
