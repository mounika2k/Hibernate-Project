package com.myapp.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.myapp.model.Category;
import com.myapp.model.Country;
import com.myapp.model.Employee;
import com.myapp.model.India;
import com.myapp.model.Product;
import com.myapp.model.Student;
import com.myapp.model.Uk;

public class HibernateUtil {
//All hibernate specific configs and DB connection will go here...
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
	if(sessionFactory==null) {
		try {
			Configuration configuration = new Configuration();
			//hbn settings from xml given.
			Properties props=new Properties();
			//url username password dialect driver.
			props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			props.put(Environment.URL, "jdbc:mysql://localhost:3306/mounika?user=root");
			props.put(Environment.USER,"root");
			props.put(Environment.PASS, "Password123");
			props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			props.put(Environment.SHOW_SQL, true);
			props.put(Environment.HBM2DDL_AUTO, "update");
			//submit props to config class
			configuration.setProperties(props);
			// add entity classes for mapping
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(Category.class);
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Country.class);
			configuration.addAnnotatedClass(India.class);
			configuration.addAnnotatedClass(Uk.class);
			configuration.addAnnotatedClass(Employee.class);
			ServiceRegistry serviceRegistry=
					new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		}
		catch(Exception e) {
			
		}
	}
	return sessionFactory;
	}
	}
