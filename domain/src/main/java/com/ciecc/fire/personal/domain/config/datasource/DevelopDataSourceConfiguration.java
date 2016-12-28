package com.ciecc.fire.personal.domain.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

@Component
@Profile("develop")
@PropertySource("classpath:jdbc.properties")
public class DevelopDataSourceConfiguration implements DataSourceConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();

		dataSource.setDriverClassName(environment.getProperty("develop.driver"));
		dataSource.setUrl(environment.getProperty("develop.url"));
		dataSource.setUsername(environment.getProperty("develop.username"));
		dataSource.setPassword(environment.getProperty("develop.password"));

		return dataSource;

	}

}
