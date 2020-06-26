package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.utils.Result;
import com.demo.springboot.helloworld.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    HotelService hotelService;

    /*
    编写人：王子宇
    时间：2020/6/18
    概述：查找关系的映射，用于酒店搜索
    详情：
    showAll显示全部酒店
    searchByMul实现高级搜索
    searchByName实现按名称搜索
    searchByStar实现按星级搜索
    searchById实现按酒店ID搜索
     */

    @RequestMapping("/showAll")
    @ResponseBody
    public Object getHotels(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "25") int pageSize) {
        return Result.success(hotelService.showAll(pageNo, pageSize));
    }

    @RequestMapping("/searchByMul")
    @ResponseBody
    public Object getHotelsByCity(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, String city) {
        return Result.success(hotelService.selectByMul(pageNo, pageSize, city));
    }

    @RequestMapping("/searchByName")
    @ResponseBody
    public Object getHotelsByName(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, String hotelName) {
        return Result.success(hotelService.selectByName(pageNo, pageSize, hotelName));
    }

    @RequestMapping("/searchByStar")
    @ResponseBody
    public Object getHotelsByStar(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, int starRating) {
        return Result.success(hotelService.selectByStar(pageNo, pageSize, starRating));
    }

    @RequestMapping("/searchById")
    @ResponseBody
    public Object getHotelsByStar(int hotel_id) {
        return Result.success(hotelService.selectById(hotel_id));
    }
}
