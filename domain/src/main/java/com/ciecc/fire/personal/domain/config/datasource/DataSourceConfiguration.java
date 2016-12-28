package com.ciecc.fire.personal.domain.config.datasource;

import javax.sql.DataSource;

/***
 * handles configuring the datasource per environment
 * @author fire
 *
 */
public interface DataSourceConfiguration {
	DataSource dataSource();
}
