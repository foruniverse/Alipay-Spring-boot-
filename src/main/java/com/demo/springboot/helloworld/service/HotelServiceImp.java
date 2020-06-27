package com.demo.springboot.helloworld.service;


import com.demo.springboot.helloworld.common.domain.Hotel;
import com.demo.springboot.helloworld.common.domain.HotelExample;
import com.demo.springboot.helloworld.mapper.HotelMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HotelServiceImp implements HotelService {
    @Autowired
    HotelMapper hotelMapper;

    @Override
    public PageInfo<Hotel> showAll(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Hotel> hotels = hotelMapper.selectByExample(null);
        PageInfo<Hotel> hotelPageInfo = new PageInfo<>(hotels);
        return hotelPageInfo;
    }

    public PageInfo<Hotel> selectByMul(int pageNo, int pageSize, String city) {
        PageHelper.startPage(pageNo, pageSize);
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        criteria.andCityEqualTo(city);
        List<Hotel> hotels = hotelMapper.selectByExample(example);
        PageInfo<Hotel> hotelPageInfo = new PageInfo<>(hotels);
        return hotelPageInfo;
    }

    ;

    public PageInfo<Hotel> selectByName(int pageNo, int pageSize, String hotelName) {
        PageHelper.startPage(pageNo, pageSize);
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        hotelName = "%" + hotelName + "%";
        criteria.andHotelNameLike(hotelName);
        List<Hotel> hotels = hotelMapper.selectByExample(example);
        PageInfo<Hotel> hotelPageInfo = new PageInfo<>(hotels);
        return hotelPageInfo;
    }

    ;

    public PageInfo<Hotel> selectByStar(int pageNo, int pageSize, int starRating) {
        PageHelper.startPage(pageNo, pageSize);
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        criteria.andStarRatingEqualTo(starRating);
        List<Hotel> hotels = hotelMapper.selectByExample(example);
        PageInfo<Hotel> hotelPageInfo = new PageInfo<>(hotels);
        return hotelPageInfo;
    }

    ;

    public List<Hotel> selectById(int hotel_id) {
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        criteria.andHotelIdEqualTo(hotel_id);
        List<Hotel> hotels = hotelMapper.selectByExample(example);
        return hotels;
    }

    ;
}
