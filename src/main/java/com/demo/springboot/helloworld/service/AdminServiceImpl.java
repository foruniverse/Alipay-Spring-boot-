package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Admin;
import com.demo.springboot.helloworld.common.domain.AdminExample;
import com.demo.springboot.helloworld.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andLoginnameEqualTo(admin.getLoginname());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        return (admins.size()>0?admins.get(0):null);
    }
}
