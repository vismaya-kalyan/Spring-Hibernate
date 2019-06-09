package spring;

public class CricketCoach implements Coach {
	
	private FortuneService myFortuneService;
	private String email;
	
	
	public CricketCoach() {
		System.out.println("CricketCoach no-arg constructor");
	}

	public void setMyFortuneService(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Catch Catch play!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return myFortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
