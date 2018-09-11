package com.example.demo.configPool.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 创建人:连磊
 * 日期: 2018/9/6. 9:36
 * 描述：
 */
//声明这个是配置实体
@Configuration
//扫描需要的dao包
@MapperScan(basePackages = "com.example.demo.dao.db2" , sqlSessionFactoryRef = "db2sqlSessionFactory")
public class Data2ConfigPool {

    private static final String MAPPER_LOCAL = "classpath*:com/example/demo/mapper/db2/*.xml";

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "second.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager db2DataSourceTransactionManager(){
        return new DataSourceTransactionManager(druidDataSource());
    }

    @Bean(value = "db2sqlSessionFactory")
    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource")DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sqlSessionFactoryBean.getObject();
    }

}
