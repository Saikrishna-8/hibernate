package org.sai.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sai.hibernate.entity.Users1;

class app {
	public static void main(String[] args) {

		System.out.println("Started main excution");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users1.class)
				.buildSessionFactory();

		System.out.println("creating session object");
		Session session = factory.getCurrentSession();

		System.out.println("Done!!!!");

		try {
			Users1 user = new Users1("saikrishna_08", "Fassak@08", "SAI KRISHNA", "BADINEEDI");
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			System.out.println("Row Added");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// session.close();
			// factory.close();
		}
	}
}