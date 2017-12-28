package com.mapping.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory factory=buildfactory();
	
	private static SessionFactory buildfactory(){
		
		/*return new Configuration().configure().buildSessionFactory();*/
				
		final Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder().applySettings(configuration.getProperties());
	    //final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    return configuration.buildSessionFactory(builder.buildServiceRegistry());
	       
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
