package com.xiongping.transacation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author xiongping
 * @date 2024-08-01
 */
@Configuration
public class Config {

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(getDatasource());
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(getDatasource());
		return transactionManager;
	}

	@Bean
	public DataSource getDatasource() {
		String url = "jdbc:mysql://192.168.10.125:3306/home_account";
//		String url = "jdbc:mysql://10.68.8.26:3306/twin_vision_platform?useUnicode=true&characterEncoding=UTF8&rewriteBatchedStatements=true&serverTimezone=PRC&useSSL=false&allowMultiQueries=true";
		String username = "root";
		String password = "123@abcd";
//		String password = "123456";
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
