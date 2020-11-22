package domain;

public class RandomNumbers{
	private int random;
	
	public RandomNumbers() {
		this.random = 0;
	}

	public int getRandomNumber() {
		return this.random;
	}
	
	public void generateRandomFive() {
		this.random = (int) ((Math.random()*(4))+ 1);
	}
	
	public void generateRandomTen() {
		this.random = (int) ((Math.random()*(9))+ 1);
	}
	
	public void generateRandomTwenty() {
		this.random = (int) ((Math.random()*(19))+ 1);
	}
	
	public void generateRandom(int min, int max) {
		this.random = (int) ((Math.random()*(max-min))+ min);
	}
	
	//for testing purposes only
	public void setNumber(int number) {
		this.random = number;
	}
	


}
