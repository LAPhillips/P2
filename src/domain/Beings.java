package domain;

public class Beings {
	private String name;
	private int hitpoints;
	private int baseAttack = 20;
	private int defense;
	private int attack;
	private boolean alive;
	
	public Beings() {
		this.name = "noName";
		this.hitpoints = 0;
		this.defense = 0;
		this.attack = 0;
		this.alive = true;
	}
	
	public Beings(String inputName, int defense) {
		this.name = inputName;
		this.defense = defense;
		this.hitpoints = 0;
		this.attack = 0;
		this.alive = true;
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
	
	public int attackModifier() {
		return (int) (Math.random()*(6)+1);
	}
	
	public int attack() {	
		setAttackPoints(attackModifier());	
		return this.attack;
	}
	
	public void damaged(int hitAmount) {
		hitpoints -= hitAmount;
	}
	
	public int getAttackPoints() {
		return this.attack;
	}
	
	public void setAttackPoints(int attack) {
		this.attack = attack;
	}

	public int seeIfAttack(int levelOfDifficulty) { //for special attacks
		if (levelOfDifficulty == 2) {
			return (int) (Math.random()*(20) + 3);
		}
		return (int) (Math.random()*(20));
	}
	
	public int seeIfAttack() { //standard will be 20
		return (int) (Math.random()*(20));
	}

	public void checkDeath() {
		if (hitpoints <= 0) {
			alive = false;
		}
	}

	public boolean isAlive() {
		return this.alive;
	}
	
	
}
