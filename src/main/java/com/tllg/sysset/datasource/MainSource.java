package com.tllg.sysset.datasource;

import com.tllg.util.PropertyUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.io.IOException;


/**
 * @author lgli
 * 初始化主数据源
 * 数据源连接池 --> 会话工厂sqlSessionFactoryBean --> 自动扫描对象关系映射 --> 事务管理
 */
@Configuration
@EnableTransactionManagement//支持事物
public class MainSource implements TransactionManagementConfigurer {

    private static final Logger log = LoggerFactory.getLogger(MainSource.class);

    @Autowired
    private PropertyUtil propertyUtil;

    private PooledDataSource datasource;

    private SqlSessionFactory sessionFactory;






    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        initDataSource();
        return new DataSourceTransactionManager(datasource);
    }

    /**
     * 初始化数据源及其连接
     */
    @Bean(name="mainDatasource")
    public PooledDataSource initDataSource(){
        try {
            PooledDataSource datasource = new PooledDataSource();
            //设置连接驱动-数据库类型
            datasource.setDriver(propertyUtil.getValueByKey("default.datasource.driverClassName"));
            //设置URL
            datasource.setUrl(propertyUtil.getValueByKey("default.datasource.url"));
            //设置用户名
            datasource.setUsername(propertyUtil.getValueByKey("default.datasource.username"));
            //设置密码
            datasource.setPassword(propertyUtil.getValueByKey("default.datasource.password"));
            //连接池其他信息默认PooledDataSource中的属性
            this.datasource = datasource;
            return datasource;
        }catch (Exception e){
            log.error("初始化主数据源连接池失败，"+e,e);
            throw new RuntimeException("初始化主数据源连接池失败异常"+e);
        }
    }


    /**
     * 注册sqlSessionFactoryBean
     *
     */
    @Bean(name="mainSqlSessionFactory")
    public SqlSessionFactory registerSqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.datasource);//设置数据源
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //指定xml配置文件路径
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/tllg/**/mapper/xml/*.xml"));
            this.sessionFactory = sqlSessionFactoryBean.getObject();
            return this.sessionFactory;
        }catch (IOException ioe){
            log.error("主数据源配置Mapper映射文件不存在"+ioe,ioe);
            throw new RuntimeException("配置Mapper映射文件不存在"+ioe);
        }catch (Exception ex){
            log.error("主数据源注册sqlSessionFactoryBean异常"+ex,ex);
            throw new RuntimeException("主数据源注册sqlSessionFactoryBean异常"+ex);
        }
    }

    /**
     * 注册sqlSessionTemplate
     * @param factory SqlSessionFactory
     * @return
     */
    @Bean(name="mainSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }


}
