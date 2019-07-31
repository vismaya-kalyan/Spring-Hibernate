package spring.jdbc;

import spring.jdbc.entity.Instructor;
import spring.jdbc.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();
			
			InstructorDetail temp_detail = session.get(InstructorDetail.class, 6);
			
			System.out.println("InstructorDetail: "+temp_detail);
			System.out.println("Instructor: "+temp_detail.getIns());
			
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
