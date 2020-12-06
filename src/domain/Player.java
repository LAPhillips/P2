package domain;

public class Player extends Beings {

	public Player(String inputName, int playerDefense) {
		super(inputName, playerDefense);
	}
	
	public void calculateHitpoints() {
		int hitpoints = (int) ((Math.random()*(30))+ 20); 
		super.setHitpoints(hitpoints);
	}
	
	public void heal(int healAmount) {
		int hp = super.getHitpoints();
		hp += healAmount;
		super.setHitpoints(hp);
	}
	
	public int healAmount() {
		return (int) ((Math.random()*(4))+1);
	}
	
}
