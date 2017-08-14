package com.daxueit.springmvc.beans.profile;


/**
 * Created by Administrator on 2017/8/13.
 */
public class ProfileBean {
    private String msg;
    public ProfileBean(String msg){
        this.msg=msg;
        System.out.println("I am "+msg);
    }
}
