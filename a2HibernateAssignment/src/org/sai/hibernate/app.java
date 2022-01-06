package org.sai.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.sai.hibernate.entity.Student;
class app {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		System.out.println("Done!!!!");

		try {

			String[] names = { "SAI", "KRISHNA", "BADE", "BYD", "KUMARI", "SURESH", "HIMA", "VARSHITH", "MEGHANA",
					"JHANSI" };
			int[] marks = { 99, 88, 77, 66, 55, 44, 43, 33, 22, 11 };
			// Student student1 = new Student("HARISH ", 98);
			Transaction tx = session.beginTransaction();

			Student student = null;
			for (int i = 0; i < 10; i++) {
				student = new Student("BSAI ", 99);
				student.setName(names[i]);
				student.setMarks(marks[i]);
				session.save(student);
				session.flush();
				session.clear();
			}
			System.out.println("Rows were  Added ");
			
			//student = session.get(Student.class, 3);
			//student = session.get(Student.class);
			session.createQuery("delete from Student where marks <=35")
			.executeUpdate();
			// Deleting a Record with user id 8
			//session.delete(student);

			System.out.println("DELETED   "+student);
			session.flush();
			session.clear();
			
			student = session.get(Student.class, 4);
			System.out.println(" RETRIEVING  "+student);
			session.flush();
			session.clear();
			
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SAI   " + e.getMessage());
		} finally {
			session.close();
			factory.close();
		}
	}

}