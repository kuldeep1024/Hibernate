package com.test.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {

			// Hibernate 3
			/* return new Configuration().configure().buildSessionFactory(); */

			final Configuration configuration = new Configuration().configure();
			// Hibernate 4.2
			ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());

			// Hibernate 4.3+
			// final StandardServiceRegistryBuilder builder = new
			// StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			return configuration.buildSessionFactory(builder.buildServiceRegistry());

		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
