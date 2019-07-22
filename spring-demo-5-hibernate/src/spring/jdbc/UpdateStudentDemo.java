package spring.jdbc;

import spring.jdbc.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			
			int studentId = 1;
			
//			Create Session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrive student based on the id : primary key
			Student mystudent = session.get(Student.class, studentId);
			
			System.out.println("Gets complete" + mystudent);
			
			mystudent.setFirstName("Scooby");
			
//			commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

}
