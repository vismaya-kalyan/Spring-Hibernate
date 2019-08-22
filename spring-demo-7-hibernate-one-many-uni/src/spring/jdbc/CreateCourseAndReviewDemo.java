package spring.jdbc;

import spring.jdbc.entity.Course;
import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;
import spring.jdbc.entity.Review;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

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
		
//			Create a course
			Course tempCourse = new Course("the PacMan");
	
//			add some reviews
			tempCourse.addReview(new Review("Great Tutorial"));
			tempCourse.addReview(new Review("Nice Tutorial"));
			tempCourse.addReview(new Review("Regret taking this tutorial"));
			tempCourse.addReview(new Review("How is this even in popular"));
						
//			save the course and leverage the cascade all :)
			System.out.println("Saving the Course");
			session.save(tempCourse);		
			
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
