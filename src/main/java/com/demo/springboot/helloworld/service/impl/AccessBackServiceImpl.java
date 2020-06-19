package com.demo.springboot.helloworld.service.impl;


import com.demo.springboot.helloworld.entity.*;
import com.demo.springboot.helloworld.mapper.AccessBackMapper;
import com.demo.springboot.helloworld.service.AccessBackService;
import com.demo.springboot.helloworld.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AccessBackServiceImpl implements AccessBackService {

    @Resource
    private AccessBackMapper accessBackMapper;


    @Override
    public void regist(ZUser zUser){
        try{
            Map<String ,Object> map = new HashMap<String ,Object>();
            map.put("mail",zUser.getEmail());

            ZUser u=accessBackMapper.findZUserByEmail(map);
            if(u!=null){
                throw new RuntimeException("此账号已经注册过了");
            }

            ZCode zCode=accessBackMapper.findCode(map);
            if(zCode==null){
                throw new RuntimeException("请先获取验证码");
            }
            if(!zUser.getCode().equals(zCode.getCode())){
                throw new RuntimeException("验证码不正确");
            }
            accessBackMapper.updateCode(zCode);

            zUser.setId(UUID.randomUUID().toString());
            zUser.setCreatetime(new Date());
            zUser.setLevel(1);
            zUser.setName(zUser.getEmail());
            accessBackMapper.regist(zUser);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public void getCode(String email){
        try {

            SendMailUtil sendMailUtil = new SendMailUtil();
            String code=sendMailUtil.send(email);

            //保存到数据库
            ZCode zCode =new ZCode();
            zCode.setId(UUID.randomUUID().toString());
            zCode.setCode(code);
            zCode.setMail(email);
            zCode.setStatus("1");
            zCode.setCreatetime(new Date());

            accessBackMapper.getCode(zCode);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public ZUser login(ZUser zUser) {
        try{
            ZUser user = accessBackMapper.login(zUser);
            if(user==null){
                throw new RuntimeException("用户名或密码错误");
            }
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ZUser updateZUser(ZUser zUser) {
        try{
            accessBackMapper.updateZUser(zUser);
            return accessBackMapper.findZUserById(zUser.getId());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Transactional
    public Map<String,Object> uploadPhoto(MultipartFile file) throws Exception {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        AttrFileTool attrFileTool = new AttrFileTool();
        if (file != null) {
            String path = attrFileTool.FWPATH + attrFileTool.saveFile(file);
            returnMap.put("url", path);
        }
        return returnMap;
    }

    @Transactional
    public void updatePassword(ZUser zUser) {
        try{
            Map<String ,Object> map = new HashMap<String ,Object>();
            map.put("mail",zUser.getEmail());
            ZCode zCode=accessBackMapper.findCode(map);
            if(zCode==null){
                throw new RuntimeException("请先获取验证码");
            }
            if(!zUser.getCode().equals(zCode.getCode())){
                throw new RuntimeException("验证码不正确");
            }
            accessBackMapper.updateCode(zCode);

            ZUser user=accessBackMapper.findZUserByEmail(map);
            if(user==null){
                throw new RuntimeException("用户不存在");
            }
            user.setPassword(zUser.getPassword());
            accessBackMapper.updateZUser(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Transactional
    public Map<String,Object> findOrder(ZOrder zOrder) {
        zOrder.setPage(pageUtil.getPage(zOrder.getPage(),zOrder.getPageSize()));

        Map<String,Object> returnMap = new HashMap<String,Object>();
        List<ZOrder> list=accessBackMapper.findOrder(zOrder);
        List<ZOrder> returnList =new ArrayList<ZOrder>();
        for (ZOrder order:list) {
            if("0".equals(order.getStatus())){
                order.setStatus("未支付");
            }else if("1".equals(order.getStatus())){
                order.setStatus("已支付");
            }else if("-1".equals(order.getStatus())){
                order.setStatus("已取消");
            }else if("2".equals(order.getStatus())){
                order.setStatus("已退款");
            }
            returnList.add(order);
        }

        returnMap.put("dataList",returnList);


        returnMap.put("count",accessBackMapper.findOrderCount(zOrder));
        return returnMap;
    }

    @Transactional
    public Map<String,Object> findOrderDetail(ZOrderDetail zOrderDetail) {
        zOrderDetail.setPage(pageUtil.getPage(zOrderDetail.getPage(),zOrderDetail.getPageSize()));

        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("dataList",accessBackMapper.findOrderDetail(zOrderDetail));
        returnMap.put("count",accessBackMapper.findOrderDetailCount(zOrderDetail));
        return returnMap;
    }

    @Override
    public Map<String, Object> findZUser(ZUser zUser) {
        zUser.setPage(pageUtil.getPage(zUser.getPage(),zUser.getPageSize()));

        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("dataList",accessBackMapper.findZUser(zUser));
        returnMap.put("count",accessBackMapper.findZUserCount(zUser));
        return returnMap;
    }

    @Override
    public void deleteZUser(ZUser zUser) {
        String[] r=zUser.getId().split(",");
        for (int i = 0; i < r.length; i++) {
            accessBackMapper.deleteZUser(r[i]);
        }

    }

}
