package com.demo.springboot.helloworld;

import com.demo.springboot.helloworld.common.domain.Order;
import com.demo.springboot.helloworld.common.domain.OrderDetail;
import com.demo.springboot.helloworld.mapper.AccessBackMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloworldApplicationTests {

    @Autowired
    private AccessBackMapper accessBackMapper;

    @Test
    public void insertOrder() {
        Order order = new Order();
        order.setStatus("trade_success");
        order.setEmail("yannay@qq.com");
        order.setHotel("江南大酒店");
        order.setHotel_id(1);
        order.setMobile("1234");
        order.setRoom_id(2);
        order.setUid(1);
        order.setTotleprice(89.99);
        int order1 = accessBackMapper.insertOrderInfo(order);
        System.out.println(order1);
        System.out.println(order.getId());

    }

    @Test
    public void updateOrder() {
        Order order = new Order();
        order.setStatus("trade_finished");
        order.setId(6);
        accessBackMapper.updateOrderState(order);
    }

    @Test
    public void inserOrderDetail() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(9);
        orderDetail.setName("张三");
        orderDetail.setPrice(89.00);
        orderDetail.setRoom(1);
        orderDetail.setRoomtype("情侣房");
        orderDetail.setRemark("大碗宽面一晚");
        accessBackMapper.insertOrderDetail(orderDetail);

    }
}
