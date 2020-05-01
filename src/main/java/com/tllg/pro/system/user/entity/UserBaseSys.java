package com.tllg.pro.system.user.entity;

import com.tllg.util.UtilBase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 系统用户类，用于登录系统后，存放Anthority信息
 * 使用SpringSecurity需要实现UserDetails，方便MyUserDetailsService方式loadUserByUsername
 * 返回本类
 */

public class UserBaseSys extends UserBaseInfo implements UserDetails {


    /**
     * 重写构造方法，方便构造实体类
     * @param userBaseInfo
     */
    public UserBaseSys(UserBaseInfo userBaseInfo) {
        if(userBaseInfo == null){
            return;
        }
        setUserId(userBaseInfo.getUserId());
        setUserName(userBaseInfo.getUserName());
        setUserUniqueSign(userBaseInfo.getUserUniqueSign());
        setUserPassword(userBaseInfo.getUserPassword());
        setUserSex(userBaseInfo.getUserSex());
        setUserBirthday(userBaseInfo.getUserBirthday());
        setUserEducation(userBaseInfo.getUserEducation());
        setUserContact(userBaseInfo.getUserContact());
        setUserStatus(userBaseInfo.getUserStatus());
        setUserCreater(userBaseInfo.getUserCreater());
        setUserCreateDate(userBaseInfo.getUserCreateDate());
    }

    /**
     * 权限认证构建
     * @return 权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String username = this.getUsername();
        if (UtilBase.STRING.isNoneBlank(username)){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("123");
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getUserPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
