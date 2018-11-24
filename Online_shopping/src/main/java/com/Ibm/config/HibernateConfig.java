package com.Ibm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.Ibm.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	private static String DATABASE_URL = "jdbc:mysql://localhost:3307/raghu";
	private static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private static String DATABASE_USERNAME = "root";
	private static String DATABASE_PASSWORD = "root";

	@Bean("dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;

	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.Ibm.dto");
		return builder.buildSessionFactory();

	}
	
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory factory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(factory);
		return transactionManager;
	}

	
}
