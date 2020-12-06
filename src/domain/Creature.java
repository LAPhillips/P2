package domain;

public class Creature extends Beings{
	private CreatureGenerator generator;
	private CreatureDifficulty difficulty;
	
	public Creature() {
		this.generator = new CreatureGenerator();
		this.difficulty = null;
	}
	
	public void setupCreature() {
		setRandomDifficulty();
		setRandomName();
		setRandomDefense();
		setRandomizedHitpoints();
	}
	
	public void setRandomizedHitpoints() {
		int hp = generator.getRandomizedHitPoints();
		setHitpoints(hp);
	}
	
	@Override
	public int attackAndShare() {
		int attack = 0;
		switch(this.difficulty) {
		case EASY:
			attack = (int) ((Math.random()*(3)+1));
			break;
		case MEDIUM:
			attack = (int) ((Math.random()*(5))+2);
			break;
		case HARD:
			attack = (int) ((Math.random()*(7))+3);
			break;
		}	
		super.setAttackPoints(attack);
		return attack;
	}
	
	@Override
	public String toString() {
		return super.getName() + " has " + super.getHitpoints() + " hit points.";
	}

	//****************basic getters & setters*******************************

	public void setRandomName() {
		super.setName(generator.newCreatureName());
	}
	
	public void setRandomDefense() {
		super.setDefense(generator.generateDefense());
	}
	
	public CreatureDifficulty getDifficulty() {
		return this.difficulty;
	}
	
	public void setRandomDifficulty() {
		this.difficulty = generator.generateDifficulty();
	}
}
