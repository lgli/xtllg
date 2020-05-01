package com.tllg.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author tllg
 * 项目启动类
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan({"com.tllg.*"})
public class TllgEntryApplication {
    public static void main(String[] args){
        SpringApplication.run(TllgEntryApplication.class,args);
    }
}
