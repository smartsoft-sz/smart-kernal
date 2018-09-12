package com.smart.configurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

import static com.smart.core.ProjectConstant.*;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
public class MybatisConfigurer {


    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

//    @Bean
//    @Primary
//    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
        return factory.getObject();
    }

//    @Bean(name = "sqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

    @Bean
//    @Primary
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }

//    @Bean(name = "erpDataSource")
//    @ConfigurationProperties(prefix = "spring.erpdatasource")
//    public DruidDataSource erpDatasource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "erpSqlSessionFactoryBean")
//    public SqlSessionFactory erpSqlSessionFactoryBean(@Qualifier("erpDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setTypeAliasesPackage("com.smart.erp.model");
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:erpmapper/**/*.xml"));
//        return sessionFactory.getObject();
//    }
//
//    @Bean(name = "erpJdbcTemplate")
//    public SqlSessionTemplate erpSqlSessionTemplate(@Qualifier("erpSqlSessionFactoryBean")  SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    public MapperScannerConfigurer erpMapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("erpSqlSessionFactoryBean");
//        mapperScannerConfigurer.setBasePackage("com.smart.erp.dao");
//
//        //配置通用Mapper，详情请查阅官方文档
//        Properties properties = new Properties();
//        properties.setProperty("mappers", "com.smart.erp.core.ErpMapper");
//        mapperScannerConfigurer.setProperties(properties);
//
//        return mapperScannerConfigurer;
//    }

    //    @Bean
//    public DataSourceTransactionManager erpTransactionManager(@Qualifier("erpDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

}

