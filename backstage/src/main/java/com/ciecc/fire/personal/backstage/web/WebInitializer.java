package com.ciecc.fire.personal.backstage.web;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ciecc.fire.personal.backstage.config.RootConfiguration;
import com.ciecc.fire.personal.backstage.web.config.WebConfig;

/***
 * SecurityWebApplicationInitializer 中的 AbstractSecurityWebApplicationInitializer已经implements WebApplicationInitializer
 * @author fire
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeforeWebStartConfig.class);
		SettingFactory setting = context.getBean(SettingFactory.class); 
		String ctx = setting.getCtx();
		context.close();*/
		
		servletContext.setInitParameter("spring.profiles.default", "develop");

	}

	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();  
        characterEncodingFilter.setEncoding("UTF-8");  
        characterEncodingFilter.setForceEncoding(true);  
        DelegatingFilterProxy securityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");  
        return new Filter[] {characterEncodingFilter, securityFilterChain, new HiddenHttpMethodFilter() };  
	}

	

	/*@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//web初始化前加载
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeforeWebStartConfig.class);
		SettingFactory setting = context.getBean(SettingFactory.class); 
		String ctx = setting.getCtx();
		context.close();
		
		servletContext.setInitParameter("spring.profiles.default", "develop");
		//初始化web
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		servletContext.setAttribute("ctx", ctx);
		webApplicationContext.register( WebConfig.class, SecurityConfig.class, ServiceConfig.class, JdbcConfiguration.class, JpaConfiguration.class, CgiConfig.class); //AopConfig.class, ProfileConfig.class,
		webApplicationContext.setServletContext(servletContext);
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		//设置session跟踪的cookie的生命周期（以秒为单位）
		SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
		sessionCookieConfig.setMaxAge(1800);
	}*/

}
