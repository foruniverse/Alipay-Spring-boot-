package com.demo.springboot.helloworld.mapper;


import com.demo.springboot.helloworld.entity.ZCode;
import com.demo.springboot.helloworld.entity.ZOrder;
import com.demo.springboot.helloworld.entity.ZOrderDetail;
import com.demo.springboot.helloworld.entity.ZUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccessBackMapper {

    ZCode findCode(Map<String,Object> map);

    void updateCode(ZCode zCode);

    void regist(ZUser zUser);

    void getCode(ZCode zCode);

    ZUser login(ZUser zUser);

    ZUser findZUserById(String id);

    void updateZUser(ZUser zUser);

    ZUser findZUserByEmail(Map<String,Object> map);

    List<ZOrder> findOrder(ZOrder zOrder);

    int findOrderCount(ZOrder zOrder);

    List<ZOrderDetail> findOrderDetail(ZOrderDetail zOrderDetail);

    int findOrderDetailCount(ZOrderDetail zOrderDetail);

    List<ZUser> findZUser(ZUser zUser);

    int findZUserCount(ZUser zUser);

    int deleteZUser(String id);

}
