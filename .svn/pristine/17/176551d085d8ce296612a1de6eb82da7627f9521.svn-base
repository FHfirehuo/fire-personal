package com.ciecc.fire.personal.portal.config;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.ciecc.fire.personal.portal.setting.SettingFactory;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		servletContext.setInitParameter("spring.profiles.default", "develop");
		// web初始化前加载
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeforeWebStartConfig.class);
		SettingFactory setting = context.getBean(SettingFactory.class);
		String ctx = setting.getCtx();
		String site = setting.getSite();
		String siteResources = setting.getSiteResources();
		context.close();
		
		servletContext.setAttribute("APP_CTX", ctx);
		servletContext.setAttribute("SITE_CTX", site);
		servletContext.setAttribute("SITE_RESOURCES_CTX", siteResources);

	}

	
	

}
