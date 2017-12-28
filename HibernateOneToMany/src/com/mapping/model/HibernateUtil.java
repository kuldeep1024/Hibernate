package com.mapping.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory factory=buildfactory();
	
	private static SessionFactory buildfactory(){
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
