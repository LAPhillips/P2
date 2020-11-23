package domain;

public class Warrior extends Player {
	private PlayerType type;

	public Warrior(String inputName) {
		super(inputName, -4);
		this.type = PlayerType.WARRIOR;
	}
	
	public void calculateHitpoints() {
		 //sage has lower hit points, but higher hit
		int hitpoints = (int) ((Math.random()*(50))+ 20);
		super.setHitpoints(hitpoints);
	}

	//charge is an attack that lets do more than normal damage

}
