package com.tllg.sysset.datasource;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MainSource.class)
public class MainMapper {
    /**
     * 注册Mapper映射文件信息
     */
    @Bean(name="mainMapperScannerConfigurer")
    public MapperScannerConfigurer registerMapperConfig(){
        MapperScannerConfigurer mapper = new MapperScannerConfigurer();
        //指定sqlSessionFactory
        mapper.setSqlSessionFactoryBeanName("mainSqlSessionFactory");
        //指定dao接口配置文件路径
        mapper.setBasePackage("com.tllg.**.mapper");
        return mapper;
    }




}
