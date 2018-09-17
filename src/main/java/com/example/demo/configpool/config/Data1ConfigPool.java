package com.example.demo.configpool.config;

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
@MapperScan(basePackages = "com.example.demo.dao.db1" , sqlSessionFactoryRef = "db1sqlSessionFactory")
public class Data1ConfigPool {

    /**
     * 扫描xml文件
     **/
    private static final String MAPPER_LOCAL = "classpath*:com/example/demo/mapper/db1/*.xml";

    @Bean(name = "db1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "first.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = "db1TransactionManager")
    public DataSourceTransactionManager db1DataSourceTransactionManager(){
        return new DataSourceTransactionManager(druidDataSource());
    }

    @Primary
    @Bean(value = "db1sqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource")DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sqlSessionFactoryBean.getObject();
    }

}
