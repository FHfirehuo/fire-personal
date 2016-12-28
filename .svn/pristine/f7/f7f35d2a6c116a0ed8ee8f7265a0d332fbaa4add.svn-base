package com.ciecc.fire.personal.backstage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ciecc.fire.personal.backstage.cgi.web.interceptor.CgiInterceptor;

@Configuration
@ComponentScan("com.ciecc.fire.personal.backstage.cgi.web.controller")
public class CgiConfig extends WebMvcConfigurerAdapter{
	
	
	@Bean
	public CgiInterceptor cgii(){
		return new CgiInterceptor();
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(cgii()).addPathPatterns("/cgi/**");
	}

}
