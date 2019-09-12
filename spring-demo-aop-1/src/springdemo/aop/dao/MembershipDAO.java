package springdemo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMembership() {
		System.out.println(getClass()+"Doing my DB work: ADD Member");
	}

}
