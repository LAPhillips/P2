package domain;

public class Creature implements Beings{
	private CreatureGenerator generator;
	private String name;
	private int hitpoints;
	private int baseAttack;
	private int defense;
	private int currentHit;
	private CreatureDifficulty difficulty;
	
	public Creature() {
		this.generator = new CreatureGenerator();
		this.name = "noName";
		this.hitpoints = 0;
		this.baseAttack = 20;
		this.defense = 0;
		this.currentHit = 0;
		this.difficulty = CreatureDifficulty.EASY;
	}
	
	public void setRandomDifficulty() {
		this.difficulty = generator.generateDifficulty();
	}
	
	public CreatureDifficulty getDifficulty() {
		return this.difficulty;
	}
	
	public void setRandomName() {
		this.name = generator.newCreatureName();
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void setHitpoints(int amount) {
		
	}

	@Override
	public int getHitpoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void attacked(int attackAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void damaged(int hitAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHitAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
