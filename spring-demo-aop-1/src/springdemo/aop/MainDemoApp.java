package springdemo.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springdemo.aop.dao.AccountDAO;
import springdemo.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account theAccount = new Account();
		theAccountDAO.addAccount(theAccount);
		theAccountDAO.setName("Cloth");
		theAccountDAO.setServiceName("Serive cloth");
		
//		Account theAccount = new Account();
//		theAccount.setName("vismaya");
//		theAccount.setLevel("platinum");
		
		List<Account> theAccounts = theAccountDAO.findAccount();
		
		System.out.println("After Returning Demo");
		
		System.out.println(theAccounts);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		theMembershipDAO.addMembership();
		
		context.close();
	
	}

}
