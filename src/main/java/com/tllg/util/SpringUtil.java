package com.tllg.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lgli
 * spring框架工具类
 * BeanFactory，以Factory结尾，表示它是一个工厂类(接口)，用于管理Bean的一个工厂。
 * 在Spring中，BeanFactory是IOC容器的核心接口，它的职责包括：实例化、定位、配置应用程序中的对象及建立这些对象间的依赖。
 *
 */
@Component
public class SpringUtil implements BeanFactoryAware {
    private static Logger logger = LoggerFactory.getLogger(SpringUtil.class);

    /*
     * DefaultListableBeanFactory 该接口实现了ConfigurableListableBeanFactory, BeanDefinitionRegistry
     * 并继承了AbstractAutowireCapableBeanFactory
     * 一个重要的类
     */
    private static DefaultListableBeanFactory factory;

    /**
     * 设置管理Bean的工厂
     * @param beanFactory 传入beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory = (DefaultListableBeanFactory)beanFactory;
    }

    /**
     *  根据ID获取bean
     * @param id bean的ID
     * @param <T> 对象
     * @return 返回该bean
     */
    public static <T> T getBeanById(String id){
        return (T)factory.getBean(id);
    }

    /**
     * 根据类型获取bean
     * @param tClass 传入bean的类型
     * @param <T> 对象
     * @return 返回该bean
     */
    public static <T> T getBeanByType(Class<T> tClass){
        return factory.getBean(tClass);
    }

    /**
     * 删除容器中的bean
     * @param beanName 传入bean的名称
     */
    public static void destoryBeanById(String beanName){
        logger.info("销毁容器中的bean："+beanName);
        if (factory.containsBean(beanName)){
            factory.destroySingleton(beanName);//删除bean
            factory.removeBeanDefinition(beanName);//删除bean的定义
        }else{
            logger.error(beanName+"不存在，删除失败");
        }
    }

    /**
     * 向容器中添加bean
     * @param beanClass bean的类型
     * @param beanName bean的名称
     * @param autoResource 初始化时，需要自动注入的其他引用对象，key要注入的属性，value要注入的对象
     * @param initMethod 初始化方法
     * @param destoryMethod 销毁方法
     */
    public static void addBean(Class<?> beanClass,String beanName,
                               Map<String,Object> autoResource,String initMethod,String destoryMethod){
        if (!factory.containsBean(beanName)){
            final BeanDefinitionBuilder builder =
                    BeanDefinitionBuilder.genericBeanDefinition(beanClass);
            if (null != autoResource && !autoResource.isEmpty()){
                //注入初始化bean需要注入的其他引用对象
                for(String key : autoResource.keySet()){
                    builder.addPropertyValue(key,autoResource.get(key));
                }
            }
            if (!StringUtils.isEmpty(initMethod)){
                //注入初始化方法名称
                builder.setInitMethodName(initMethod);
            }
            if (!StringUtils.isEmpty(destoryMethod)){
                builder.setDestroyMethodName(destoryMethod);
            }
            //注册bean
            factory.registerBeanDefinition(beanName,builder.getBeanDefinition());
            logger.info("添加bean("+beanName+"):"+factory.getBean(beanName)+"成功!");
        }else{
            logger.error("需要注入的bean已经存在，请重新指定bean的名字");
        }
    }

    /**
     * 向容器中添加单例bean
     * @param beanName 单例bean的名称
     * @param object 该bean对象
     */
    public static void addSingleBean(String beanName,Object object){
        if (factory.containsBean(beanName)){
            factory.registerSingleton(beanName,object);
        }else{
            logger.error("添加单例的"+beanName+"失败：已经存在！");
            throw new RuntimeException("添加单例的"+beanName+"失败：已经存在！");
        }
    }
}
