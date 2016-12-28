package com.ciecc.fire.personal.backstage.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ciecc.fire.personal.backstage.security.UserService;

@Configuration
@EnableWebSecurity
//@ComponentScan("com.ciecc.fire.personal.backstage.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	private DataSourceConfiguration dataSourceConfiguration;*/
	
	/*@Autowired
	private UserService userService;*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//第一种
		auth.inMemoryAuthentication().withUser("fire").password("openfire").roles("")
		.and().withUser("fire1").password("openfire").roles("");
		
		//第二种
		//auth.jdbcAuthentication().dataSource((DataSource) dataSourceConfiguration);
		
		//第三种
		auth.jdbcAuthentication().dataSource((DataSource) dataSourceConfiguration)
		.usersByUsernameQuery("sql1")
		.authoritiesByUsernameQuery("sql2");
		
		//第四种
		auth.userDetailsService(userService);
	}*/

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/cgi/**","/signup","/user").permitAll()  //所有人都可以访问
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		//.and().formLogin().loginPage("security/login").permitAll()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().logoutUrl("/signout").permitAll();
		//.and().logout().logoutUrl("/logout").logoutSuccessUrl("").permitAll();
		logoutSuccessHandler(logoutSuccessHandler)                              
		.invalidateHttpSession(true)                                             
		.addLogoutHandler(logoutHandler)                                         
		.deleteCookies(cookieNamesToClear)                                       
		.and()
	}*/

	/*@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(web);
		 web.ignoring().antMatchers(); 
	}*/

}
