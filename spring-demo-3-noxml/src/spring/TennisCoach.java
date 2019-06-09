package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	public FortuneService myFortuneService;
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "play";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return myFortuneService.getFortune();
	}

}
