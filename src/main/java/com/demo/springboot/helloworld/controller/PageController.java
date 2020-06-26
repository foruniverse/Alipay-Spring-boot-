package com.demo.springboot.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

//    @RequestMapping("/admin/view/pay/list.html")
//    public String pay()
//    {
//        return "/admin/view/pay/list.html";
//    }

    @RequestMapping("/admin/index.html")
    public String index() {
        return "/admin/index.html";
    }

    @RequestMapping("/admin/preindex.html")
    public String preindex() {
        return "/admin/preindex.html";
    }
}
