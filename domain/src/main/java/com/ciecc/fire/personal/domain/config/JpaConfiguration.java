package com.ciecc.fire.personal.domain.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.ciecc.fire.personal.domain.config.datasource.DataSourceConfiguration;

@Configuration
@ComponentScan("com.ciecc.fire.personal.domain.config.datasource")
@EnableJpaRepositories(value = { "com.ciecc.fire.personal.domain", "com.ciecc.fire.personal.portal.sercurity.data" })
public class JpaConfiguration {

	@Autowired
	private DataSourceConfiguration dataSourceConfiguration;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setDataSource(dataSourceConfiguration.dataSource());

		// 指定实体类的路径
		em.setPackagesToScan(new String[] { "com.ciecc.fire.personal.domain", "com.ciecc.fire.personal.portal.sercurity.data" });

		// 指定Jpa持久化实现厂商类,这里以Hibernate为例
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.format_sql", "true");
		//jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");

		em.setJpaProperties(jpaProperties);
		em.setPersistenceUnitName("jpa-hibernate");
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return em;

	}

	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		EntityManagerFactory entityManagerFactory = entityManagerFactory().getObject();
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	/*@Bean
	@DependsOn("entityManagerFactory")
	public ResourceDatabasePopulator initDatabase(DataSource dataSource) throws Exception {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("data.sql"));
		populator.populate(dataSource.getConnection());
		return populator;
	}*/

}
