package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class TennisCoach implements Coach{
	@Autowired
	@Qualifier("randomFortuneService")
	public FortuneService theFortuneService;

//	@Autowired
//	public void setTheFortuneService(FortuneService theFortuneService) {
//		this.theFortuneService = theFortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "swing if possible";
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return theFortuneService.getFortune();
	}
}
