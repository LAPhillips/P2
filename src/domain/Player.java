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
	
	public void setupAttack(int attackType) {
		if (attackType == 2) {
			
		}
	}
	
	public int attackModifier(int hitType) {
		if (hitType == 2) {
			return (int) (Math.random()*(10)+3);
		}
		return (int) (Math.random()*(6)+1);
	}
	
	public int attack(int hitType) {	
		setAttackPoints(attackModifier(hitType));	
		return super.getAttackPoints();
	}
	
	
	
	@Override
	public String toString() {
		return super.getName() + " has " + super.getHitpoints() + " hit points";
	}
	
	
}
