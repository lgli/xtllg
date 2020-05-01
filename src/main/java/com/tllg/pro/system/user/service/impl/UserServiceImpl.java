package com.tllg.pro.system.user.service.impl;


import com.tllg.pro.system.user.mapper.UserMapper;
import com.tllg.pro.system.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;



    @Override
    public String selectMain() {
        return userMapper.selectMain();
    }
}
