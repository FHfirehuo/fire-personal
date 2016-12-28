package com.ciecc.fire.personal.backstage.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ciecc.fire.personal.backstage.web.interceptor.RequestTimeInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.ciecc.fire.personal.backstage.web.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/classes/views/"); // 这是编译后的目录
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;

	}*/

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resource/**").addResourceLocations("classpath:/resource/");
	}*/

	@Bean 
	public RequestTimeInterceptor rti() {
		return new RequestTimeInterceptor();

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(rti());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/login").setViewName("index");
		super.addViewControllers(registry);
	}

}
