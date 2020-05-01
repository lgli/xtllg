package com.tllg.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author lgli
 * 配置文件读取工具，系统启动，自动读取application.properties文件
 * 读取文件信息，方便使用
 */
@Component
public class PropertyUtil extends PropertyPlaceholderConfigurer {
    //记录日志
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    private Properties properties;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        try {
            InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream("config/application.properties");
            props.load(inputStream);
        }catch (Exception e){
            logger.error("读取配置文件信息异常："+e,e);
        }
        super.processProperties(beanFactoryToProcess, props);
        properties = props;
    }

    /**
     * 获取application.properties中所有信息
     * @return map
     */
    public Map<String,String>  getPropertiesInfo(){
        Map<String,String> map = new HashMap<>();
        for (Map.Entry<Object,Object> entry : properties.entrySet()){
            map.put((String) entry.getKey(),(String) entry.getValue());
        }
        return map;
    }

    /**
     * 获取对应key的value值
     * @param key 给定的key值
     * @return string
     */
    public String getValueByKey(String key){
        return properties.getProperty(key);
    }

    /**
     * 获取对应key的value值，没有则默认
     * @param key 给定的key值
     * @param defaultValue 没有key的value值返回的默认值
     * @return String
     */
    public String getValueByKey(String key,String defaultValue){
       return properties.getProperty(key,defaultValue);
    }

    /**
     * 设置key和value
     * @param key 给定key
     * @param value 对应value
     * @return Object
     */
    public Object setProperty(String key,String value){
        return properties.setProperty(key,value);
    }


}
