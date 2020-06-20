package com.demo.springboot.helloworld.service;


import com.demo.springboot.helloworld.entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface AccessBackService {

    void regist(ZUser zUser);

    void getCode(String email);

    ZUser login(ZUser zUser);

    ZUser updateZUser(ZUser zUser);

    Map<String,Object> uploadPhoto(MultipartFile file) throws Exception;

    void updatePassword(ZUser zUser);

    Map<String,Object> findOrder(ZOrder zOrder);

    Map<String,Object> findOrderDetail(ZOrderDetail zOrderDetail);

    Map<String,Object> findZUser(ZUser zUser);

    void deleteZUser(ZUser zUser);
}
