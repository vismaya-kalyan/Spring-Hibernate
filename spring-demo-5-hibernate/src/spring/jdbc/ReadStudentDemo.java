package spring.jdbc;

import spring.jdbc.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
			Student temp = new Student("Daffy","duck","Daffy.duck@gmail.com");
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			System.out.println("Saving..");
			session.save(temp);
			
			System.out.println("Commit");
			session.getTransaction().commit();
			
//			Find out the student based primary key
			System.out.println("Saved student generated id " + temp.getId());
			
//			new code
//			get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrive student based on the id : primary key
			Student mystudent = session.get(Student.class,temp.getId());
			System.out.println("Gets complete" + mystudent);
//			commit the transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
