/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DJSpringbootApp.Model.Data;

import java.util.Properties;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author L117student
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "Model")
public class PersistenceJDBCConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
		throws NamingException {
		LocalContainerEntityManagerFactoryBean emf
			= new LocalContainerEntityManagerFactoryBean();

		emf.setDataSource(dataSource());
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		// Following required to avoid looking for persistence.xml
		emf.setPackagesToScan("Model");
		emf.setPersistenceUnitName("products-pu");
		emf.setLoadTimeWeaver(new ReflectiveLoadTimeWeaver());

		Properties properties = new Properties();
		properties.setProperty("eclipselink.logging.level", "FINE");
		properties.setProperty("eclipselink.logging.level.sql", "FINE");
		properties.setProperty("eclipselink.logging.parameters", "true");
		emf.setJpaProperties(properties);
		emf.afterPropertiesSet();

		return emf;
	}

	@Bean
	public DataSource dataSource() throws NamingException {
		return (DataSource) new JndiTemplate()
			.lookup("java:comp/env/jdbc/myProducts");
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}