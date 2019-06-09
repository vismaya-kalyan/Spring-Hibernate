package spring;
import java.util.Random;
public class RandomFortuneService implements FortuneService {

	private String[] toppings = {"Cheese", "Pepperoni", "Black Olives"};
	Random rand = new Random();
	@Override
	public String getFortune() {
		int n = rand.nextInt(3);
		return toppings[n];
	}

}
