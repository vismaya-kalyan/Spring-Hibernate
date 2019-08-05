package spring.jdbc;

import spring.jdbc.entity.Course;
import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

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
				
			System.out.println("begin transaction");
			session.beginTransaction();
			
			int theid = 1;
			Instructor tempInstructor = session.get(Instructor.class, theid);
			
			Course c1 = new Course("Legendary");
			Course c2 = new Course("Play Book");
			
			tempInstructor.add(c1);
			tempInstructor.add(c2);
			
			session.save(c1);
			session.save(c2);
			
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
