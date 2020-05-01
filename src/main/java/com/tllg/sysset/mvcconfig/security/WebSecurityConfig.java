package com.tllg.sysset.mvcconfig.security;

import com.tllg.sysset.mvcconfig.auth.MyAuthProvider;
import com.tllg.sysset.mvcconfig.user.MyUserDetailsService;
import com.tllg.sysset.mvcconfig.handler.MyFailHandler;
import com.tllg.sysset.mvcconfig.handler.MySuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author lgli
 * 安全信息配置
 * 项目基本配置信息，主要包括登录拦截，静态资源访问
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private MyAuthProvider myAuthProvider;







    @Override
    public void configure(WebSecurity web){
        //定义登录页面的静态资源（包括js）
        web.ignoring().antMatchers("/login/**",//登录界面及其资源
                "/login.html",//登录界面及其资源
                "/base/js/**",//主要js,jquery及其vue
                "/*.ico"//图标
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()//定义需要用户登录时，跳转到登录页面
            .loginPage("/login.html")//定义登录页面
            .usernameParameter("username").passwordParameter("password")//定义登录界面传参
            .loginProcessingUrl("/login_to_sys")//登录接口,该接口被SpringSecurity执行;
            .permitAll()//表示不需要拦截，全部通过
            .failureHandler(new MyFailHandler())//登录失败处理handler
            .successHandler(new MySuccessHandler())//登录成功处理handler
            .and().headers().frameOptions().sameOrigin()//保证同源iframe中可访问，不拦截
            .and().authorizeRequests().anyRequest().authenticated()
            .and().csrf().disable()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
        auth.authenticationProvider(myAuthProvider);
//        auth.eraseCredentials(true);
    }


}
