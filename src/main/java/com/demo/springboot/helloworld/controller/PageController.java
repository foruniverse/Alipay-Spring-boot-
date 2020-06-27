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

    @RequestMapping("/")
    public String index() {
        return "/admin/index.html";
    }

    @RequestMapping("/admin/preindex.html")
    public String preindex() {
        return "/admin/preindex.html";
    }

    @RequestMapping("/admin/tour.html")
    public String tour() {
        return "/admin/tour.html";
    }

    @RequestMapping("/admin/404.html")
    public String  file_404() {
        return "/admin/404.html";
    }

    @RequestMapping("/admin/gallery.html")
    public String gallery() {
        return "/admin/gallery.html";
    }

    @RequestMapping("/admin/about-us.html")
    public String about_us() {
        return "/admin/about-us.html";
    }

    @RequestMapping("/admin/booking-step.html")
    public String booking_step() {
        return "/admin/booking-step.html";
    }

    @RequestMapping("/admin/contact-us-v1.html")
    public String contact_us() {
        return "/admin/contact-us-v1.html";
    }

    @RequestMapping("/admin/destination-detail.html")
    public String destination_detail() {
        return "/admin/destination-detail.html";
    }

    @RequestMapping("/admin/destination-list.html")
    public String destination_list() {
        return "/admin/destination-list.html";
    }

    @RequestMapping("/admin/faq.html")
    public String faq() {
        return "/admin/faq.html";
    }

    @RequestMapping("/admin/hotel-detail.html")
    public String hotel_detail() {
        return "/admin/hotel-detail.html";
    }

    @RequestMapping("/admin/zh.html")
    public String zh() {
        return "/admin/zh.html";
    }
}
