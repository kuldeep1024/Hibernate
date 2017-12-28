package com.test.hibernate.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		
		SessionFactory sessionAnnotationFactory=null;
		
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure("hibernate-annotation.cfg.xml");
			System.out.println("Hibernate Annotation Configuration loaded");

			//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
			registry.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
			
			System.out.println("Hibernate Annotation serviceRegistry created");

			sessionAnnotationFactory = configuration.buildSessionFactory(serviceRegistry);

			//return sessionAnnotationFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			//throw new ExceptionInInitializerError(ex);
		}
		return sessionAnnotationFactory;
	}

}
