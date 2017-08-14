package com.daxueit.springmvc.beans.prepost;

/**
 * Created by Administrator on 2017/8/13.
 */
public class InitMethodBean2 {
    public void init(){
        System.out.println("InitMethodBean2.init()");
    }

    public void destroy(){
        System.out.println("InitMethodBean2.destroy()");
    }

    public InitMethodBean2(){
        System.out.println("InitMethodBean2构造函数");
    }
}
