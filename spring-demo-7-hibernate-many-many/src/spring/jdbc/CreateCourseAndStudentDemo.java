package spring.jdbc;

import spring.jdbc.entity.Course;
import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;
import spring.jdbc.entity.Review;
import spring.jdbc.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {
				
			System.out.println("begin transaction");
			session.beginTransaction();
		
//			Create a course
			Course tempCourse = new Course("the PacMan");
						
//			save the course and leverage the cascade all :)
			System.out.println("Saving the Course");
			session.save(tempCourse);	
			
			Student tempstu1 = new Student("mary","joe","mary@gmail.com");
			Student tempstu2 = new Student("yen","chen","chen@gmail.com");
			
			tempCourse.addStudent(tempstu1);
			tempCourse.addStudent(tempstu2);
			
			session.save(tempstu1);
			session.save(tempstu2);
			
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
