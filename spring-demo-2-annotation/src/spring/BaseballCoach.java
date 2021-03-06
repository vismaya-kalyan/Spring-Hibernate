package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
	
	
	public FortuneService theFortuneService;
	
	@Autowired
	public BaseballCoach( @Qualifier("randomFortuneService") FortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Bat if possible";
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return theFortuneService.getFortune();
	}

}
