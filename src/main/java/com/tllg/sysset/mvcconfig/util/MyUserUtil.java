package com.tllg.sysset.mvcconfig.util;


import com.tllg.sysset.exception.NoLoginException;
import com.tllg.pro.system.user.entity.UserBaseSys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取当前登录者的信息，主要在项目中使用
 * @author lgli
 */
public class MyUserUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserUtil.class);


    /**
     * 获取当前登陆者信息
     * @return
     */
    public static UserBaseSys getUserUniqueSign() throws NoLoginException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object credentials = authentication.getPrincipal();
        if(credentials instanceof UserBaseSys){
            return (UserBaseSys)credentials;
        }
        throw new NoLoginException();
    }



}
