package org.hibernate.tutorial.hbm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		System.out.println("Hibernate Configuration loaded");

		/* Above 5 */ 
		// ServiceRegistry serviceRegistry = new
		// StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		

		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
		// below 4.2  
		// ServiceRegistry serviceRegistry = new
		// ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		 
		return sessionFactory;

	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}
	
}
