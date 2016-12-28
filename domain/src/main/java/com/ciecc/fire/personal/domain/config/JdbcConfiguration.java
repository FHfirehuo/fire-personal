package com.ciecc.fire.personal.domain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ciecc.fire.personal.domain.config.datasource.DataSourceConfiguration;

@Configuration
@ComponentScan("com.ciecc.fire.personal.domain.template")
public class JdbcConfiguration {
	
	@Autowired
	private DataSourceConfiguration dataSourceConfiguration;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSourceConfiguration.dataSource());
		return jdbcTemplate;
	}

}
