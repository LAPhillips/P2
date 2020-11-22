package domain;

public class RandomTen implements RandomNumbers{
	private int random10;
	
	public RandomTen() {
		this.random10 = 0;
	}

	@Override
	public int getRandomNumber() {
		return this.random10;
	}
	
	@Override
	public void generateNumber() {
		this.random10 = (int) ((Math.random()*(9))+ 1);
	}
	
	//for testing purposes only
	@Override
	public void setNumber(int number) {
		this.random10 = number;
	}
	


}
