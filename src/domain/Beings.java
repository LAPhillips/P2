package domain;

public class Beings {
	private String name;
	private int hitpoints;
	private int baseAttack = 20;
	private int defense;
	
	public Beings() {
		this.name = "noName";
		this.hitpoints = 0;
		this.defense = 0;
	}
	
	public Beings(String inputName, int defense) {
		this.name = inputName;
		this.defense = defense;
		this.hitpoints = 0;
	}
	
	//****************basic getters & setters*******************************
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHitpoints() {
		return this.hitpoints;
	}
	
	public void setHitpoints(int amount) {
		this.hitpoints = amount;
	}
	
	public int getBaseAttack() {
		return this.baseAttack;
	}
	
	public int getDefense() {
		return this.defense;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int attack() {	
		return (int) (Math.random()*(6)+1);	
	}
	
	public void damaged(int hitAmount) {
		hitpoints -= hitAmount;
	}

	
	
}
