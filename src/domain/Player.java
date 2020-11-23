package domain;

public class Player implements Beings {
	private String name;
	private int hitpoints;
	private int baseAttack = 20;
	private int defense;
	private int currentHit;

	public Player(String inputName, int playerDefense) {
		this.name = inputName;
		this.defense = playerDefense;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHitpoints(int amount) {
		this.hitpoints = amount;
	}
	
	public int getHitpoints() {
		return this.hitpoints;
	}
	
	public int getDefense() {
		return this.defense;
	}
	
	public int getHitAmount() {
		return this.currentHit;
	}
	
	public void attacked(int attack) {
		//does the player get hit
		if(baseAttack + defense <= attack) {
			//monster hits
		//	int hit = monster.getHit();
		//	damaged(hit)
		}
	}

	public void damaged(int hitAmount) {
		hitpoints -= hitAmount;
	}


}
