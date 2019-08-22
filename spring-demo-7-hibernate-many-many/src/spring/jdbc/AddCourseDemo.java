package spring.jdbc;

import spring.jdbc.entity.Course;
import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;
import spring.jdbc.entity.Review;
import spring.jdbc.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseDemo {

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
		
			int stuid = 2;
			Student tempStu = session.get(Student.class, stuid);
			System.out.println("Recieved student: " + tempStu);
			System.out.println("course: " + tempStu.getCourses());
			
			Course temp_c1 = new Course("Rubixs cube");
			Course temp_c2 = new Course("cute paper balls");
			Course temp_c3 = new Course("laptop flexibilty");
			
			temp_c1.addStudent(tempStu);
			temp_c2.addStudent(tempStu);
			temp_c3.addStudent(tempStu);
			
			System.out.println("saving courses");
			session.save(temp_c1);
			session.save(temp_c2);
			session.save(temp_c3);
			
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
