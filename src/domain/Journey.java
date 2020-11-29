package domain;


public class Journey {
	private JourneyGenerator generator;
	private Encounter encounter;
	private Player player;
	private JourneyType type;
	private String [] path;
	private int pathTracker;
	private int distance;
	private boolean isOver;

	public Journey() {
		this.encounter = null;
		this.generator = new JourneyGenerator();
		this.path = null;
		this.pathTracker = -1;
		this.distance = 0;
		this.isOver = false;
	}
	
	//overloaded constructor for testing
	public Journey(String name) {
		this.encounter = null;
		this.generator = new JourneyGenerator();
		this.player = new Player(name, -2);
		this.pathTracker = -1;
		this.distance = 0;
		this.isOver = false;
	}
	
	public void setupJourney(String response, String playerName) {
		//set up the journey based on choice
		journeyChoice(response);
		generator.getJourney(this.type);
		path = generator.getJourney(type);
		//set up the player
		player = new Player(playerName, -2);
		player.calculateHitpoints();
		//set up first encounter
		pathTracker = 0;
		setDistanceLeft();
		newEncounter();
	}
	
	//where do you want to go? Cedar Forest? Mount Mashu? Salted Sea?
	public void journeyChoice(String response) {
		if (response.equalsIgnoreCase("C") ||
				response.equalsIgnoreCase("Cedar Forest")||
				response.equalsIgnoreCase("Cedar")) {
			type = JourneyType.SHORT;
		}
		else if (response.equalsIgnoreCase("M") ||
				response.equalsIgnoreCase("Mount Mashu")||
				response.equalsIgnoreCase("Mount") ||
				response.equalsIgnoreCase("Mashu")) {
			type = JourneyType.MEDIUM;
		}
		else {
			type = JourneyType.LONG;
		}
	}
	
	public String[] getPath() {
		return this.path;
	}
	
	public int getPathTracker() {
		return this.pathTracker;
	}
	
	public JourneyType getJourneyType() {
		return this.type;
	}

	public String encounterDescription() {		
		String pathSection = this.path[pathTracker];
		return pathSection;
	}
	
	public String getEncounterDescription() {
		return this.encounter.getDescription();
	}
	
	public void newEncounter() {
		encounter = new Encounter(encounterDescription());
		encounter.setupEncounter();
		this.pathTracker++; //every new encounter, moves path up one
		setDistanceLeft(); //every new encounter, caclculates a new distance
	}
	
	public boolean isAttack() {
		if (encounter.getEncounterType() == EncounterType.NEGATIVE) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setDistanceLeft() {
		int distance = path.length - pathTracker;
		distance *= 10;
		distance -= 10;
		int randomBit = (int) (Math.random()*(9));
		distance += randomBit;
		this.distance = distance;
	}
	
	public int getDistanceLeft() {
		return this.distance;
	}
	
	
	public Creature getCurrentCreature() {
		return encounter.getCreature();
	}
	
	public Beings getPlayer() {
		return this.player;
	}
	
	public void checkDeath(Beings attacker, Beings attacked) {
		attacker.checkDeath();
		attacked.checkDeath();
	}
	
	public EncounterType getLookType() {
		return encounter.getLookType();
	}
	
	public Encounter getLook() {
		encounter.updateLooked();
		return encounter;
	}
	
	public boolean getAlreadyLooked() {
		return encounter.alreadyLooked();
	}
	
	public int heal() {
		int amount = player.healAmount();
		player.heal(amount);
		return amount;
	}

	public Creature getNewCreature() {
		return encounter.getNewCreature();
	}
	
	public boolean getIsOver() {
		return this.isOver;
	}
	
	public void updateIsOver() {
		this.isOver = true;
	}
	
	public boolean isHit(Beings attacker, Beings attacked) {
		int attackRoll = attacker.seeIfAttack();
		if (attacked.getBaseAttack() + attacked.getDefense() >= attackRoll) {
			return true;
		}
		return false;
	}
	
	public void takesDamage(Beings attacker, Beings attacked) {
		int hit = attacker.attack(); //if yes, the creature calculates how much they hit for
		attacked.damaged(hit); //player takes damage
	}



	
	

}
