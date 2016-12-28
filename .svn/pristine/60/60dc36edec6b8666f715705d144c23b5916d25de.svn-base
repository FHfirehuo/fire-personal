package com.ciecc.fire.personal.backstage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ciecc.fire.personal.backstage.setting.SettingFactory;

@Configuration
@ComponentScan("com.ciecc.fire.personal.backstage.setting")
@PropertySource("classpath:settings.properties")
public class BeforeWebStartConfig {
	
	@Value("${app.ctx}")
	private String ctx;

	@Bean
	public SettingFactory settingFactory(){
		return new SettingFactory(ctx);
		
	}

}
