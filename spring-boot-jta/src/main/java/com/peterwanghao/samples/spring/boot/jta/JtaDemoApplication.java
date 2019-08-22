package com.peterwanghao.samples.spring.boot.jta;

import org.hsqldb.jdbc.pool.JDBCXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jta.bitronix.BitronixXADataSourceWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName: JtaDemoApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年8月22日 上午10:44:44
 * @version V1.0
 * 
 */
@EnableAutoConfiguration
@EnableTransactionManagement
@Configuration
@ComponentScan
public class JtaDemoApplication {

	@Bean("dataSourceAccount")
	public DataSource dataSource() throws Exception {
		return createHsqlXADatasource("jdbc:hsqldb:mem:accountDb");
	}

	@Bean("dataSourceAudit")
	public DataSource dataSourceAudit() throws Exception {
		return createHsqlXADatasource("jdbc:hsqldb:mem:auditDb");
	}

	private DataSource createHsqlXADatasource(String connectionUrl)
			throws Exception {
		JDBCXADataSource dataSource = new JDBCXADataSource();
		dataSource.setUrl(connectionUrl);
		dataSource.setUser("sa");
		BitronixXADataSourceWrapper wrapper = new BitronixXADataSourceWrapper();
		return wrapper.wrapDataSource(dataSource);
	}

	@Bean("jdbcTemplateAccount")
	public JdbcTemplate jdbcTemplate(
			@Qualifier("dataSourceAccount") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("jdbcTemplateAudit")
	public JdbcTemplate jdbcTemplateAudit(
			@Qualifier("dataSourceAudit") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
