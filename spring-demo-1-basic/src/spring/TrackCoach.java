package spring;

public class TrackCoach implements Coach {

	private FortuneService myFortuneService;
	
	public TrackCoach(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run for an hour";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return myFortuneService.getFortune();
	}

}
