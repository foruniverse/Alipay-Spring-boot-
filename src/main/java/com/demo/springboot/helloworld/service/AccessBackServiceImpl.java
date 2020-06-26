package com.demo.springboot.helloworld.service;
/*
编写人:
编写功能:登录、注册、获取验证码、修改用户信息、修改密码、上传图片、
用户订单管理列表、用户订单管理详情、用户列表、删除用户
编写时间:6月11日-16日
*/

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.AccessBackMapper;
import com.demo.springboot.helloworld.service.AccessBackService;
import com.demo.springboot.helloworld.common.utils.*;
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
    public void regist(User zUser){
        try{
            Map<String ,Object> map = new HashMap<String ,Object>();
            map.put("mail",zUser.getEmail());

            User u=accessBackMapper.findUserByEmail(map);
            if(u!=null){
                throw new RuntimeException("此账号已经注册过了");
            }

            Code zCode=accessBackMapper.findCode(map);
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
            Code zCode =new Code();
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
    public User login(User zUser) {
        try{
            User user = accessBackMapper.login(zUser);
            if(user==null){
                throw new RuntimeException("用户名或密码错误！");
            }
            if(user.getLevel()==0){
                throw new RuntimeException("该账户已被禁用！");
            }
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User updateUser(User zUser) {
        try{
            accessBackMapper.updateUser(zUser);
            return accessBackMapper.findUserById(zUser.getId());
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
    public void updatePassword(User zUser) {
        try{
            Map<String ,Object> map = new HashMap<String ,Object>();
            map.put("mail",zUser.getEmail());
            Code zCode=accessBackMapper.findCode(map);
            if(zCode==null){
                throw new RuntimeException("请先获取验证码");
            }
            if(!zUser.getCode().equals(zCode.getCode())){
                throw new RuntimeException("验证码不正确");
            }
            accessBackMapper.updateCode(zCode);

            User user=accessBackMapper.findUserByEmail(map);
            if(user==null){
                throw new RuntimeException("用户不存在");
            }
            user.setPassword(zUser.getPassword());
            accessBackMapper.updateUser(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Transactional
    public Map<String,Object> findOrder(Order zOrder) {
        zOrder.setPage(pageUtil.getPage(zOrder.getPage(),zOrder.getPageSize()));

        Map<String,Object> returnMap = new HashMap<String,Object>();
        List<Order> list=accessBackMapper.findOrder(zOrder);
        List<Order> returnList =new ArrayList<Order>();
        for (Order order:list) {
            if("WAIT_BUYER_PAY".equals(order.getStatus())){
                order.setStatus("交易创建，等待买家付款");
            }else if("TRADE_CLOSED".equals(order.getStatus())){
                order.setStatus("未付款交易超时关闭，或支付完成后全额退款");
            }else if("TRADE_SUCCESS".equals(order.getStatus())){
                order.setStatus("交易支付成功");
            }else if("TRADE_FINISHED".equals(order.getStatus())){
                order.setStatus("交易结束，不可退款");
            }
            returnList.add(order);
        }

        returnMap.put("dataList",returnList);


        returnMap.put("count",accessBackMapper.findOrderCount(zOrder));
        return returnMap;
    }

    @Transactional
    public Map<String,Object> findOrderDetail(OrderDetail zOrderDetail) {
        zOrderDetail.setPage(pageUtil.getPage(zOrderDetail.getPage(),zOrderDetail.getPageSize()));

        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("dataList",accessBackMapper.findOrderDetail(zOrderDetail));
        returnMap.put("count",accessBackMapper.findOrderDetailCount(zOrderDetail));
        return returnMap;
    }

    @Override
    public Map<String, Object> findUser(User zUser) {
        zUser.setPage(pageUtil.getPage(zUser.getPage(),zUser.getPageSize()));

        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("dataList",accessBackMapper.findUser(zUser));
        returnMap.put("count",accessBackMapper.findUserCount(zUser));
        return returnMap;
    }

    @Override
    public void deleteUser(User zUser) {
        String[] r=zUser.getId().split(",");
        for (int i = 0; i < r.length; i++) {
            accessBackMapper.deleteUser(r[i]);
        }

    }

    @Override
    public User selectUser(String id) throws Exception {
        return accessBackMapper.selectid(id);
    }

    @Override
    public List<Order> selOrderById(String id) {
        return accessBackMapper.selOrderById(id);
    }


    //--------------------------------------------by hcy
    @Override
    public int insertOrderInfo(Order order) {
        return accessBackMapper.insertOrderInfo(order);
    }

    @Override
    public void updateOrderState(Order order) {
        accessBackMapper.updateOrderState(order);
    }

    @Override
    public void insertOrderDetail(OrderDetail orderDetail) {
        accessBackMapper.insertOrderDetail(orderDetail);
    }

    @Override
    public void updateOrderDetailState(OrderDetail orderDetail) {
        accessBackMapper.updateOrderDetailState(orderDetail);
    }
//--------------------------------------------by hcy
}
