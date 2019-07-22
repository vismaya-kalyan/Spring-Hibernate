package spring.jdbc;

import spring.jdbc.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			displayMethod(theStudent);
			
			theStudent = session.createQuery("from Student s where s.lastName ='duck'").getResultList();
			
			displayMethod(theStudent);
			
			theStudent = session.createQuery("from Student s where s.lastName ='duck' OR s.firstName='asds'").getResultList();
			
			displayMethod(theStudent);
			
			theStudent = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			displayMethod(theStudent);
					
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	private static void displayMethod(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
		System.out.print("\n");
	}

}
