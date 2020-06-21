package com.demo.springboot.helloworld.service;


import com.demo.springboot.helloworld.common.domain.*;
import org.springframework.web.multipart.MultipartFile;

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
}
