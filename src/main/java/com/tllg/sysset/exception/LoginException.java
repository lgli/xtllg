package com.tllg.sysset.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义登录异常
 * 主要处理登录异常信息
 */
public class LoginException extends AuthenticationException {

    public LoginException(String msg, Throwable t) {
        super(msg, t);
    }

    public LoginException(String msg) {
        super(msg);
    }
}
