package domain;

public class Player{
	private RandomNumbers randomNumber = new RandomNumbers();
	private PlayerTypes type;
	private String name;
	private int hitpoints;
//	private Defense defense;
//	private Attack attack;
	
	public Player(String inputName) {
		this.type = null;
		this.name = inputName;
		this.hitpoints = 0;
	}
	
	public void setPlayerType(PlayerTypes playerType) {
		this.type = playerType;
	}
	
	public void setHitpoints() {
		if (type == PlayerTypes.SAGE) { //sage has lower hit points, but higher hit
			randomNumber.generateRandom(20, 50);
			this.hitpoints = randomNumber.getRandomNumber();
		}
		else {
			randomNumber.generateRandom(40, 70); //warriors have higher hit points but lower hit
			this.hitpoints = randomNumber.getRandomNumber();
		}
	}
	
	public void playerAttacked(int attack) {
		this.hitpoints -= attack;
	}
	
	public int playerAttacks() {
		int attack = 0;
		if (type == PlayerTypes.SAGE) { //sage has lower hit points, but higher hit
			randomNumber.generateRandomTen();
			attack = randomNumber.getRandomNumber() + 2;
		}
		else {
			randomNumber.generateRandom(40, 70); //warriors have higher hit points but lower hit
			randomNumber.generateRandomFive();
			attack = randomNumber.getRandomNumber() + 2;
		}
		return attack;
	}
	
	
	
	
	
	
//player has hitpoints
//player has a name
//player has defense
//player has attack
//player has type of class
	
}
