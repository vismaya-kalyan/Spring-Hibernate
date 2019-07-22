package spring.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
//		Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 new object");
			Student temp1 = new Student("Paul","Laurence","laurence.paul@gmail.com");
			Student temp2 = new Student("asds","aetgr","asds.aetgr@gmail.com");
			Student temp3 = new Student("ftrt","ssff","ftrt.ssff@gmail.com");
			
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			System.out.println("Saving..");
			session.save(temp1);
			session.save(temp2);
			session.save(temp3);			
			
			System.out.println("Commit");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
