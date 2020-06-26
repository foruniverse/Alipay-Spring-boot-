package com.demo.springboot.helloworld.mapper;
/*
编写人:
编写功能:登录、注册、获取验证码、修改用户信息、修改密码、上传图片、
用户订单管理列表、用户订单管理详情、用户列表、删除用户
编写时间:6月11日-16日
*/

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

    User selectid(String id);

    List<Order> selOrderById(String id);

    //by hcy
    int insertOrderInfo(Order order);

    // by hcy 更新订单状态
    void updateOrderState(Order order);

    //by hcy 插入detaildingdan
    void insertOrderDetail(OrderDetail orderDetail);

    void updateOrderDetailState(OrderDetail orderDetail);

}
