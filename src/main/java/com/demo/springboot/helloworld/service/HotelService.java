package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Hotel;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface HotelService {

    /*
    编写人：王子宇
    时间：2020/6/18
    概述：查找功能函数，参数为查找时的关键值，返回一个json
    详情：
    showAll查找所有酒店
    selectByMul多条件查找
    selectByName按名称查找
    selectByStar按星级查找
    selectById按酒店ID查找
     */

    public PageInfo<Hotel> showAll(int pageNo, int pageSize);

    public PageInfo<Hotel> selectByMul(int pageNo, int pageSize, String city);

    public PageInfo<Hotel> selectByName(int pageNo, int pageSize, String hotelName);

    public PageInfo<Hotel> selectByStar(int pageNo, int pageSize, int starRating);

    public List<Hotel> selectById(int hotel_id);

}
