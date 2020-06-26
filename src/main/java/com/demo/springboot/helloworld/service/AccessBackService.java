package com.demo.springboot.helloworld.service;


import com.demo.springboot.helloworld.common.domain.*;
import org.springframework.web.multipart.MultipartFile;
/*
编写人: 谢倩倩
编写功能:登录、注册、获取验证码、修改用户信息、修改密码、上传图片、
用户订单管理列表、用户订单管理详情、用户列表、删除用户
编写时间:6月11日-16日
*/
import java.util.List;
import java.util.Map;

public interface AccessBackService {

    void regist(User zUser);

    void getCode(String email);

    User login(User zUser);

    User updateUser(User zUser);

    Map<String,Object> uploadPhoto(MultipartFile file) throws Exception;

    void updatePassword(User zUser);

    Map<String,Object> findOrder(Order zOrder);

    Map<String,Object> findOrderDetail(OrderDetail zOrderDetail);

    Map<String,Object> findUser(User zUser);

    void deleteUser(User zUser);

    User selectUser(String id) throws Exception;

    List<Order> selOrderById(String id);
}
