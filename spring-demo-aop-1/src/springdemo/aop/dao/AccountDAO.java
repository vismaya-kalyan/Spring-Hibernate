package springdemo.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springdemo.aop.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceName;
	
	public List<Account> findAccount(){
		List<Account> myAccount = new ArrayList<>();
		Account temp1 = new Account("vismaya","Silver");
		Account temp2 = new Account("ffff","xxxx");
		Account temp3 = new Account("rrrrr","tttt");
		
		myAccount.add(temp3);
		
		myAccount.add(temp2);
		
		myAccount.add(temp1);
		
		return myAccount;
	}
	
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass()+"Doing my DB work: ADD Account");
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	public String getServiceName() {
		System.out.println("getServiceName");
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		System.out.println("setServiceName");
		this.serviceName = serviceName;
	} 

	
}
