package com.tllg.sysset.mvcconfig.auth;

import com.tllg.common.StaticEnum;
import com.tllg.sysset.exception.LoginException;
import com.tllg.sysset.mvcconfig.user.MyUserDetailsService;
import com.tllg.pro.system.user.entity.UserBaseSys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author lgli
 * 认证服务类
 */
@Component
public class MyAuthProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService myUserDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String)authentication.getCredentials();
        UserBaseSys userDetails = (UserBaseSys)myUserDetailsService.loadUserByUsername(name);
        if (!password.equals(userDetails.getPassword())){
            throw new LoginException("WRONG_PASS");
        }
        if (StaticEnum.ONE.getValue().equals(userDetails.getUserStatus())){
            throw new LoginException("FORBID_PASS");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,authentication.getCredentials(),authentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
