package org.sai.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sai.hibernate.entity.Users1;


public class Delete {

  public static void main(String[] args) {
	  
	  SessionFactory factory = new Configuration()
			                   .configure("hibernate.cfg.xml")
			                   .addAnnotatedClass(Users1.class)
			                   .buildSessionFactory();
	  
	  Session session = factory.getCurrentSession();
	  
	  try {
		  // Create object of entity class type
		  Users1 user = new Users1();
		  // Start transaction
		  session.beginTransaction();
		  // Perform operation
		  user = session.get(Users1.class, 1);
		  //Deleting a Record with user id 8
		  session.delete(user);
		  
		  // Commit the transaction 
		  session.getTransaction().commit();
		  System.out.println(user);
		  
		
	} finally {
		session.close();
		factory.close();
	}
	
}
}






