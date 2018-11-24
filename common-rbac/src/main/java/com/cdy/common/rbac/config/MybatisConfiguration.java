package com.cdy.common.rbac.config;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan("com.cdy.common.rbac.mapper")
public class MybatisConfiguration {

	@Bean
	public DataSource druidDataSource(MysqlProperties properties) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(properties.getUrl());
		dataSource.setDriverClassName(properties.getDriverClass());
		dataSource.setUsername(properties.getUserName());
		dataSource.setPassword(properties.getPassword());
		dataSource.setLoginTimeout(2);
		dataSource.setBreakAfterAcquireFailure(true);
		dataSource.setConnectionErrorRetryAttempts(0);
		try {
			dataSource.init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.cdy.common.rbac.entiy");
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = null;
		try {
			resources = resolver.getResources("classpath:mapper/*.xml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sqlSessionFactoryBean.setMapperLocations(resources);
		try {
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
	
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
