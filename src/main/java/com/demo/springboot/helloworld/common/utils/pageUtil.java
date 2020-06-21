package com.demo.springboot.helloworld.common.utils;
/*编写人：谢倩倩
编写功能：分页
编写时间：6月15-16日*/
public class pageUtil {

    public static int getPage(int page,int pageSize){
        return (page-1)*pageSize;
    }


}
