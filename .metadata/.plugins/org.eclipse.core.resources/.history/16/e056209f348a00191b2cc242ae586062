package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Coach theCoach = new TrackCoach();
//		System.out.println(theCoach.getDailyWorkout());
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		context.close();
		
	}
	

}
