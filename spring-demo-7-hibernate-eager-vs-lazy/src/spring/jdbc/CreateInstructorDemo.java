package spring.jdbc;

import spring.jdbc.entity.Course;
import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new object");
			Instructor temp = new Instructor("suzan","public","susan@gmail.com");
			InstructorDetail temp_detail = new InstructorDetail("youtubee","jump");
			
			temp.setInstructorDetail(temp_detail);
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			System.out.println("Saving..");
			session.save(temp);
			
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
