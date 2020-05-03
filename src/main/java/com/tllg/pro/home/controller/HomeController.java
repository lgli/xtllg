package com.tllg.pro.home.controller;


import com.tllg.pro.system.user.entity.UserBaseSys;
import com.tllg.sysset.mvcconfig.util.MyUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 主页面controller
 * @author lgli
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    /**
     * 进入主页面
     * @param request request
     * @return String
     */
    @RequestMapping("/entryHomeIndex")
    public String entryHomeIndex(HttpServletRequest request) throws Exception{
//        String requestURI = request.getRequestURI();

        UserBaseSys userUniqueSign = MyUserUtil.getUserUniqueSign();
        //设置菜单权限
        request.setAttribute("menu",userUniqueSign.getUserResource());
        return "home/home";
    }




}
