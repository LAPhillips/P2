package domain;

public class Beings {
	private String name;
	private int hitpoints;
	private int baseAttack;
	private int defense;
	private int attack;
	private int attackBonus;
	private boolean alive;
	
	public Beings() {
		this.name = "noName";
		this.hitpoints = 0;
		this.baseAttack = 20;
		this.defense = 0;
		this.attack = 0;
		this.attackBonus = 0;
		this.alive = true;
	}
	
	public Beings(String inputName, int defense) {
		this.name = inputName;
		this.hitpoints = 0;
		this.baseAttack = 20;
		this.defense = defense;
		this.attack = 0;
		this.attackBonus = 0;
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
	
	public int getAttackPoints() {
		return this.attack;
	}
	
	public void setAttackPoints(int attack) { 
		this.attack = attack;
	}
	
	public int getAttackBonus() {
		return this.attackBonus;
	}
	
	public void setAttackBonus(int bonus) {
		this.attackBonus = bonus;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	//****************battle methods*******************************

	public int attackModifier() {
		return (int) (Math.random()*(6)+1);
	}

	public void damaged(int hitAmount) {
		hitpoints -= (hitAmount +  + attackBonus);
	}
	
	public int attack() {	
		setAttackPoints(attackModifier());	
		return this.attack;
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


	
}
