package domain;

//Sages hit hard but have less HP; they can heal but it takes a turn
public class Sage extends Player{
	private PlayerType type;
	
	public Sage(String inputName) {
		super(inputName, -2);
		this.type = PlayerType.SAGE;
	}
	
	public void calculateHitpoints() {
		 //sage has lower hit points, but higher hit
		int hitpoints = (int) ((Math.random()*(30))+ 20);
		super.setHitpoints(hitpoints);
	}
	
	public void heal() {
		int healAmount = (int) ((Math.random()*(4))+ 1);
		int hpChange = healAmount + super.getHitpoints();
		super.setHitpoints(hpChange);
	}
	
	//overloaded
		public void heal(int healAmount) {
			int hpChange = healAmount + super.getHitpoints();
			super.setHitpoints(hpChange);
		}
}
