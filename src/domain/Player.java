package domain;

public class Player extends Beings {
	private PlayerType type;
	
	public Player(String inputName, int playerDefense) {
		super(inputName, playerDefense);
	}
	
	public void setType(PlayerType playerType) {
		this.type = playerType;
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
	
	@Override
	public String toString() {
		return super.getName() + " has " + super.getHitpoints() + " hit points";
	}
	
	
}
