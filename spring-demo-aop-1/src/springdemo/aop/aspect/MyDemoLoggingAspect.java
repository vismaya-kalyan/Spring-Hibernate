package springdemo.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import springdemo.aop.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* springdemo.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* springdemo.aop.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* springdemo.aop.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNotGetterSetter() {}
	
	
	@Before("forDaoPackageNotGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n========>>> Executing @Before advice");
		
		MethodSignature ms = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("method:"+ ms);
		
		Object[] args = theJoinPoint.getArgs();
	
		for (Object tempArg: args) {
			System.out.println(tempArg);
		
			if (tempArg instanceof Account ){
				Account theAccount = (Account) tempArg;
				System.out.println("Name:"+ theAccount.getName());
				System.out.println("Level:"+theAccount.getLevel());
			}
		}
	
	}
	
	@Before("forDaoPackageNotGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n========>>> Performing API analytics");
	}
	@AfterReturning(pointcut="execution(* springdemo.aop.dao.AccountDAO.findAccount(..))", returning="result")
	public void afterReturningFindAccount(JoinPoint theJoinPoint, List<Account> result) {
		System.out.println("afterReturningFindAccount");
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> after ReturningFindAccount: " + method);
		System.out.println("Result: " + result);
	}

}
