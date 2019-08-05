package spring.jdbc;

import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DelDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();
			
			Instructor temp = session.get(Instructor.class, 2);
			
			if (temp != null) {
				session.delete(temp);
			}
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
