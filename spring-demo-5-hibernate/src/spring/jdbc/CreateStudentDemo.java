package spring.jdbc;

import spring.jdbc.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new object");
			Student temp = new Student("Paul","Laurence","laurence.paul@gmail.com");
			System.out.println("begin transaction");
			session.beginTransaction();
			System.out.println("Saving..");
			session.save(temp);
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
