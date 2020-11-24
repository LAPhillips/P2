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
	
	@Override
	public String toString() {
		return super.getName() + " has " + super.getHitpoints() + " hit points";
	}
	
	
}
