package com.demo.springboot.helloworld.mapper;


import com.demo.springboot.helloworld.common.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccessBackMapper {

    Code findCode(Map<String,Object> map);

    void updateCode(Code zCode);

    void regist(User zUser);

    void getCode(Code zCode);

    User login(User zUser);

    User findUserById(String id);

    void updateUser(User zUser);

    User findUserByEmail(Map<String,Object> map);

    List<Order> findOrder(Order zOrder);

    int findOrderCount(Order zOrder);

    List<OrderDetail> findOrderDetail(OrderDetail zOrderDetail);

    int findOrderDetailCount(OrderDetail zOrderDetail);

    List<User> findUser(User zUser);

    int findUserCount(User zUser);

    int deleteUser(String id);

}
