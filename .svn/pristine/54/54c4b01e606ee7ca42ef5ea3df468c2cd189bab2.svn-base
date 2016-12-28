package com.ciecc.fire.personal.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ciecc.fire.personal.portal.setting.SettingFactory;

@Configuration
@ComponentScan("com.ciecc.fire.personal.portal.setting")
@PropertySource("classpath:settings.properties")
public class BeforeWebStartConfig {

	@Value("${APP_CTX}")
	private String ctx;
	
	@Value("${SITE_CTX}")
	private String site;
	
	@Value("${SITE_RESOURCES_CTX}")
	private String siteResources;

	@Bean
	public SettingFactory settingFactory(){
		return new SettingFactory(ctx, site, siteResources);
		
	}
}
