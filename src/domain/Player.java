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
	
	public int implementHeal() {
		int amount = healAmount();
		heal(amount);
		return amount;
	}
	
	public int healAmount() {
		return (int) ((Math.random()*(4))+1);
	}
	
	
	
	public int attackAndShare(int attackType) {
		if (attackType == 1) {
			setAttackPoints((int)(Math.random()*(6)+1));	
		}
		else {
			setAttackPoints((int)(Math.random()*(10)+3));	
		}

		return this.getAttackPoints();
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
}
