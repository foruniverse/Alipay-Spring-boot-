//package com.demo.springboot.helloworld.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
////或者实现WebMvcConfigurer 接口
////public class DefaultView implements WebMvcConfigurer {
////WebMvcConfigurerAdapter已经过时
//@Configuration
//public class DefaultView extends WebMvcConfigurationSupport {
//
//    /**
//     * 添加主页方法
//     *
//     * @param registry 主页注册器
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        System.out.println("设置了主页");
//        //设置主页
//        registry.addViewController("/").setViewName("/admin/index.html");
//        //设置优先级
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        //将主页注册器添加到视图控制器中
//        super.addViewControllers(registry);
//    }
//}