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

import com.web.model.Category;
import com.web.model.Product;
import com.web.model.Supplier;
import com.web.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.web")
public class DBConfig {
	
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
		
		SessionFactory sessionFactory = factory.buildSessionFactory();
		System.out.println("--SessionFactory bean created--");
		return sessionFactory;
		
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTxManager(SessionFactory sessionFactory)
	{
		System.out.println("--txManager bean created--");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	/*@Bean(name="categoryDAO")
	public CategoryDAOImpl getCategoryDAOImpl()
	{
		return new CategoryDAOImpl();
	}*/

}
