package com.tllg.sysset.mvcconfig.resolver;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 资源路径的配置信息
 * 指定访问资源路径
 */
@Component
public class SourceResolverConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加目录配置
     * 默认配置/**
     * 可以多次使用 addResourceLocations 添加目录
     * 优先级先添加的高于后添加的
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/views/");
        super.addResourceHandlers(registry);
    }
}
