package com.tllg.sysset.mvcconfig.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author lgli
 * 登录失败处理handler
 *
 */
public class MyFailHandler implements AuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(MyFailHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException {
        logger.error("本次操作出现认证异常："+new Date());
        response.sendRedirect("/login.html?error="+e.getMessage());//返回登录页面，重新登录
    }
}
