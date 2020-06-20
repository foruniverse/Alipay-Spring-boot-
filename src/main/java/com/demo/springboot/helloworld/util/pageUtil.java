package com.demo.springboot.helloworld.util;

public class pageUtil {

    public static int getPage(int page,int pageSize){
        return (page-1)*pageSize;
    }


}
