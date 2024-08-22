package com.xiongping;

import com.xiongping.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

//@ComponentScan(value = "com.xiongping.config")
//@ComponentScan(value = "com.xiongping.model")
//@ComponentScan(value = "com.xiongping")
@ComponentScan(value = "com.xiongping.utiltest")
//@Import(UserService.class)
@PropertySource("classpath:application.properties" )
@EnableTransactionManagement // 开启事务
@Configuration
public class AppConfig {

//	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}

//	@Bean
	public TransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

//	@Bean
	public UserService userServiceBean(){
		return new UserService();
	}

//	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://192.168.10.81:3306/tuling?characterEncoding=utf-8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("123@abcd");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}


}
