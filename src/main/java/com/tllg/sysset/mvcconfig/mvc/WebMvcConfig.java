package com.tllg.sysset.mvcconfig.mvc;

import com.tllg.sysset.mvcconfig.resolver.MyLocalResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * WebMvcConfig
 * WebMvcConfigurerAdapter类来扩展springmvc的功能
 * @author lgli
 */
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private MyLocalResolver myLocalResolver;

    @Bean
    public LocaleResolver localeResolver() {
        return myLocalResolver;
    }




}
