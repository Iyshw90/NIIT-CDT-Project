package com.web.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.web.model.Cart;
import com.web.model.Category;
import com.web.model.OrderDetail;
import com.web.model.Product;
import com.web.model.Supplier;
import com.web.model.UserDetail;

/*@Configuration - indicates that the class can be used by the Spring IoC container as a source of bean definitions.*/
/*@Configuration - annotation on top of any class to declare that this class provides one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.*/

/*@EnableTransactionManagement - responsible for registering the necessary Spring components that power annotation-driven transaction management*/


/*@ComponentScan -  used to specify base packages and Spring will scan the package (and subpackages) of the classes we specify.*/

/*@Bean - annotation tells Spring that a method annotated with @Bean will return an object that should be registered as a bean in the Spring application context*/

@Configuration
@EnableTransactionManagement
@ComponentScan("com.web")
public class DBConfig {

/*@Bean - this annotation is method level annotation and it is used within a class that is annotated with @Configuration*/
	
/*Method name "getH2DataSource()" is annotated with @Bean works as bean ID and it creates and returns the actual bean "dataSource"*/
/*@Bean is used to register the "datasource" bean in Spring Ioc Container returned by "getH2DataSource()" method */

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/mydb");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		System.out.println("--DataSource bean created--");
		return datasource;
		
	}

/*@Bean is used to register the "sessionFactory" bean in Spring Ioc Container returned by "getSessionFactory()" method */
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		//this displays the sql query 
		properties.put("hibernate.show_sql", "true");
		//this displays the sql query format
		properties.put("hibernate.format_sql", "true");
		DataSource dataSource = this.getH2DataSource();
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(dataSource);
		factory.addProperties(properties);
		
		/*Adding model classes for mapping and table will be created by this.*/
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Cart.class);
		factory.addAnnotatedClass(OrderDetail.class);
		
		SessionFactory sessionFactory = factory.buildSessionFactory();
		System.out.println("--SessionFactory bean created--");
		return sessionFactory;
		
	}

/*@Bean is used to register the "txManager" bean in Spring Ioc Container returned by "getTxManager()" method */
	@Bean(name="txManager")
	public HibernateTransactionManager getTxManager(SessionFactory sessionFactory)
	{
		System.out.println("--txManager bean created--");
		return new HibernateTransactionManager(sessionFactory);
	}
	
/*@EnableTransactionManagement - Enables Spring's annotation-driven transaction management capability, similar to the support found in Spring's <tx:*> XML namespace. To be used on @Configuration classes */

	
/*The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the packages to scan for annotated components.*/
	
	
/*configuration class can have a declaration for more than one @Bean. 
 * Once your configuration classes are defined, we can load and provide them to Spring container using AnnotationConfigApplicationContext*/
}
