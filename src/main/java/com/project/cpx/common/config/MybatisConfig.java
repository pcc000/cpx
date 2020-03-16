package com.project.cpx.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:26
 * @Description:
 */
@Configuration
public class MybatisConfig implements EnvironmentAware {

    private Environment environment;

    @Bean(name = "dataSource")
    //@ConfigurationProperties(prefix = "spring.datasource.base")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        String url = environment.getProperty("spring.dataSource.url");
        String username = environment.getProperty("spring.dataSource.username");
        String password = environment.getProperty("spring.dataSource.password");
        String driverClassName = environment.getProperty("spring.dataSource.driver-class-name");

        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(100);
        dataSource.setValidationQuery("select 1 from dual");
        dataSource.setMaxWait(100000);
        return dataSource;
    }


    @Bean(name="sqlSessionFactoryBean")
    @ConditionalOnMissingBean //当容器没有指定的Bean的情况下创建该对象
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置mybatis的主配置文件
        ResourcePatternResolver resourcePatternResolver=new PathMatchingResourcePatternResolver();
        Resource mybatisXml=resourcePatternResolver.getResource("classpath:mybatis/mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisXml);
        // 配置mapper的扫描，找到所有的mapper.xml映射文件
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        //设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.project.cpx.entity");
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(@Qualifier("sqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactory(sqlSessionFactory);
        mapperScannerConfigurer.setBasePackage("com.project.cpx.dao");
        return mapperScannerConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
