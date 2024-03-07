package com.multi.artConnect.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class RootConfig {

	@Autowired
	ApplicationContext applicationContext;

	@Bean
	public DataSource dataSource() {

		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/project");
		hikariConfig.setUsername("root");
		hikariConfig.setPassword("1234");
		// 다른 구성도 추가할 수 있습니다. 예를 들어, 커넥션 풀 크기, 최대 활성 연결 수 등

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);

		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
		return sessionFactory.getObject();

	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
