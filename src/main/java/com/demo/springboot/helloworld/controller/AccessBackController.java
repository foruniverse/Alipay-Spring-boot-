package com.demo.springboot.helloworld.controller;
/*
编写人:
编写功能:登录、注册、获取验证码、修改用户信息、修改密码、上传图片、
用户订单管理列表、用户订单管理详情、用户列表、删除用户
编写时间:6月11日-16日
*/
import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.service.AccessBackService;
import com.demo.springboot.helloworld.common.utils.ResultJson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/back")
public class AccessBackController {

    @Autowired
    private AccessBackService accessBackService;

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ResultJson regist(User zUser) {
        ResultJson json = new ResultJson();
        try{
            accessBackService.regist(zUser);
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }

    @ApiOperation(value = "获取验证码")
    @RequestMapping(value = "/getCode", method = RequestMethod.POST)
    public ResultJson getCode( User zUser) {
        ResultJson json = new ResultJson();
        try{
            accessBackService.getCode(zUser.getEmail());
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultJson loginMH(User zUser) {
        ResultJson json = new ResultJson();
        try{
            json.setData(accessBackService.login(zUser));
            System.out.println(json);
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }



    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/updateUser")
    public ResultJson updateUserMH( User zUser) {
        ResultJson json = new ResultJson();
        try{
            json.setData(accessBackService.updateUser(zUser));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }

    @ApiOperation(value = "上传图片")
    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    public ResultJson uploadPhoto( MultipartFile file) {
        ResultJson json = new ResultJson();
        try{
            json.setData(accessBackService.uploadPhoto(file));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }



    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public ResultJson updatePassword(User zUser) {
        ResultJson json = new ResultJson();
        try{
            accessBackService.updatePassword(zUser);
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }
    //查看个人信息
    @ApiOperation(value = "个人信息")
    @RequestMapping("/selectid")
    public Map<Object,Object> selUser(String id){
        Map<Object,Object> map = new HashMap<Object,Object>();
        try{

            User user=accessBackService.selectUser(id);
            map.put("success", true);
            map.put("data",user);
        }catch(Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @ApiOperation(value = "用户订单管理列表")
    @RequestMapping(value = "/findOrder", method = RequestMethod.POST)
    public ResultJson findOrder( Order zOrder) {
        ResultJson json = new ResultJson();
        try{

            json.setData(accessBackService.findOrder(zOrder));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }
    @RequestMapping("selOrderById")
    public Map<Object,Object> selOrderById(String id){
        Map<Object,Object> map = new HashMap<Object,Object>();
        try{

            List<Order> order=accessBackService.selOrderById(id);
            map.put("success", true);
            map.put("data",order);
        }catch(Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @ApiOperation(value = "用户订单管理列表明细")
    @RequestMapping(value = "/findOrderDetail", method = RequestMethod.POST)
    public ResultJson findOrderDetail( OrderDetail zOrderDetail) {
        ResultJson json = new ResultJson();
        try{

            json.setData(accessBackService.findOrderDetail(zOrderDetail));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }


    @ApiOperation(value = "用户列表")
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public ResultJson findUser( User zUser) {
        ResultJson json = new ResultJson();
        try{
            json.setData(accessBackService.findUser(zUser));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ResultJson deleteUser( User zUser) {
        ResultJson json = new ResultJson();
        try{
            accessBackService.deleteUser(zUser);
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }

}
