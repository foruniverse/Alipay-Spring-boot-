package com.demo.springboot.helloworld.controller;


import com.demo.springboot.helloworld.entity.*;
import com.demo.springboot.helloworld.service.AccessBackService;
import com.demo.springboot.helloworld.util.ResultJson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/back")
public class AccessBackController {

    @Autowired
    private AccessBackService accessBackService;

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ResultJson regist(ZUser zUser) {
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
    public ResultJson getCode( ZUser zUser) {
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
    public ResultJson loginMH(ZUser zUser) {
        ResultJson json = new ResultJson();
        try{
            json.setData(accessBackService.login(zUser));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }



    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/updateZUser", method = RequestMethod.POST)
    public ResultJson updateZUserMH( ZUser zUser) {
        ResultJson json = new ResultJson();
        try{
            json.setData(accessBackService.updateZUser(zUser));
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
    public ResultJson updatePassword(ZUser zUser) {
        ResultJson json = new ResultJson();
        try{
            accessBackService.updatePassword(zUser);
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }


    @ApiOperation(value = "用户订单管理列表")
    @RequestMapping(value = "/findOrder", method = RequestMethod.POST)
    public ResultJson findOrder( ZOrder zOrder) {
        ResultJson json = new ResultJson();
        try{

            json.setData(accessBackService.findOrder(zOrder));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }


    @ApiOperation(value = "用户订单管理列表明细")
    @RequestMapping(value = "/findOrderDetail", method = RequestMethod.POST)
    public ResultJson findOrderDetail( ZOrderDetail zOrderDetail) {
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
    @RequestMapping(value = "/findZUser", method = RequestMethod.POST)
    public ResultJson findZUser( ZUser zUser) {
        ResultJson json = new ResultJson();
        try{
            json.setData(accessBackService.findZUser(zUser));
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/deleteZUser", method = RequestMethod.POST)
    public ResultJson deleteZUser( ZUser zUser) {
        ResultJson json = new ResultJson();
        try{
            accessBackService.deleteZUser(zUser);
        }catch (Exception e){
            json.setCode(-1);
            json.setMessage(e.getMessage());
        }
        return json;
    }

}
