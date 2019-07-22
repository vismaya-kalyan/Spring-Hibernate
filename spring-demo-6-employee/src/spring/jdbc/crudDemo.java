package spring.jdbc;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class crudDemo {

	public static void main(String[] args) {
//				Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(employee.class)
				.buildSessionFactory();
//		Create Session
		Session session = factory.getCurrentSession();
		
		try {
//			CREATE
			
			String theDateOfBirthStr = "31/12/1998";
	        Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
	            
			System.out.println("Creating new object");
			employee temp = new employee("Paul","Laurence",theDateOfBirth,"CCC");
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			System.out.println("Saving..");
			session.save(temp);
			
			System.out.println("Commit");
			session.getTransaction().commit();
			
//			READ
			
			System.out.println("Reading object");
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			employee mystudent = session.get(employee.class, temp.getFirstName());
			System.out.println("Gets complete" + mystudent);
			
			session.getTransaction().commit();
			
//			QUERING 
			
			System.out.println("Quering object");
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			List<employee> theEmployee = session.createQuery("from employee e where e.company LIKE '%CCC'").getResultList();
			displayEmployee(theEmployee);
			
			session.getTransaction().commit();
			
//			UPDATING
			
			System.out.println("Updating object");
			session = factory.getCurrentSession();
			
			session.beginTransaction();

			employee emp = session.get(employee.class, "Paul");
			
			System.out.println("Get complete: " + emp);
			
			emp.setCompany("Amazon");
			
			session.getTransaction().commit();
			
//			DELETING 
			
			System.out.println("Deleting object");
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			employee emp1 = session.get(employee.class, "Paul");
		
			session.delete(emp1);
			
			session.getTransaction().commit();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

	private static void displayEmployee(List<employee> theEmployee) {
		for (employee emp: theEmployee ) {
			System.out.println(emp);
		}
	}

}
