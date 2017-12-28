package org.hibernate.tutorial.hbm;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MAinTets {

	public static void main(String[] args) {
		 SessionFactory sessionFactory = new Configuration()
	                .configure("hibernate.cfg_4.2.xml") // configures settings from hibernate.cfg.xml
	                .buildSessionFactory();
		 
		 	Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save( new Event( "Our very first event!_090", new Date() ) );
			session.save( new Event( "A follow up event", new Date() ) );
			session.getTransaction().commit();
			session.close();

			// now lets pull events from the database and list them
			session = sessionFactory.openSession();
	        session.beginTransaction();
	        List result = session.createQuery( "from Event" ).list();
			for ( Event event : (List<Event>) result ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}
	        session.getTransaction().commit();
	        session.close();
	}

}
