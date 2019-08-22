package spring.jdbc;

import spring.jdbc.entity.Course;
import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;
import spring.jdbc.entity.Review;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {
				
			System.out.println("begin transaction");
			session.beginTransaction();
		
//			get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			
//			print the course
			System.out.println(tempCourse);
			
//			print the course review
			System.out.println(tempCourse.getReviews());
			
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
