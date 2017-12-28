package org.hibernate.tutorial.hbm;

import java.util.Date;

import org.hibernate.Session;


public class Tests  {
	public static void main(String[] args) {
		
		Event e = new Event();
		e.setTitle("t1");
		e.setDate(new Date());
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(e);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+e.getId());
         
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
        
        
        
        
        
        
        
      
	}
}
