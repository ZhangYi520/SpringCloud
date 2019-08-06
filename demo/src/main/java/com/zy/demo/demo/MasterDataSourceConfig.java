package com.zy.demo.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
//扫描mapper接口包
@MapperScan(basePackages = "com.zy.demo.mapper.master",sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig{

    @Value("${master.datasource.url}")
    private String masterDataSourceUrl;

    @Value("${master.datasource.username}")
    private String masterDatasourceUsername;

    @Value("${master.datasource.password}")
    private String masterDatasourcePassword;

    @Value("${master.datasource.driverClassName}")
    private String masterDatasourceDriverClassName;

    //定义dataSource的bean
    @Bean(name = "masterDataSource")
    @Primary //primary注解标志如果有多类同类bean候选，则优先考虑该bean，即主数据源
    public DataSource masterDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(masterDatasourceUsername);
        dataSource.setPassword(masterDatasourcePassword);
        dataSource.setDriverClassName(masterDatasourceDriverClassName);
        dataSource.setUrl(masterDataSourceUrl);
        return dataSource;
    }

    //定义sqlSessionFactory的bean
    @Bean(name = "masterSqlSessionFactory")
    @Primary
    //使用@Qualifier注解同样是注入bean，但该注入方式是查找bean的name
    //@Autowired注入是根据bean的类型来查找bean注入
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //扫描mapper.xml文件
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/master/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
