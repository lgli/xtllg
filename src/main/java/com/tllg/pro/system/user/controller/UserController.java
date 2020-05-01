package com.tllg.pro.system.user.controller;

import com.tllg.pro.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理
 * @author lgli
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userManager")
    @ResponseBody
    public String entryIndex(){
        return userService.selectMain();
    }

    @RequestMapping("/userManagers")
    public String userManagers(){
        return "sys/user/user";
    }


}
