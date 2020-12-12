package domain;


public class Journey {
	private JourneyGenerator generator;
	private Battle battle;
	private Encounter encounter;
	private Player player;
	private String [] path;
	private int pathTracker;
	private int distance;
	private boolean isOver;
	private Boon boon;
	private int hit;

	public Journey() {
		this.generator = new JourneyGenerator();
		this.battle = null;
		this.encounter = null;
		this.path = null;
		this.pathTracker = -1;
		this.distance = 0;
		this.isOver = false;
		this.boon = new Boon();
		this.hit = 0;
	}
	
	//overloaded constructor for testing
	public Journey(String name) {
		this.encounter = null;
		this.generator = new JourneyGenerator();
		this.player = new Player(name, -2);
		this.pathTracker = -1;
		this.distance = 0;
		this.isOver = false;
		this.boon = new Boon();
		this.hit = 0;
	}
	

	public String[] getPath() {
		return this.path;
	}
	
	public int getPathTracker() {
		return this.pathTracker;
	}
	
	public JourneyType getJourneyType() {
		return generator.getJourneyType();
	}

	public String getEncounterDescription() {
		return this.encounter.getDescription();
	}
	
	public Boon getBoon() {
		return boon;
	}
	
	public int getDistanceLeft() {
		return this.distance;
	}
	
	public Creature getCurrentCreature() {
		return encounter.getCreature();
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public EncounterType getLookType() {
		return encounter.getLookType();
	}
	
	public boolean getAlreadyLooked() {
		return encounter.alreadyLooked();
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

	public void setupJourney(String response, String playerName) {
		//set up the journey based on choice
		path = generator.implementJourney(response);
		//set up the player
		player = new Player(playerName, -2);
		player.calculateHitpoints();
		//set up first encounter
		pathTracker = 0;
		setDistanceLeft();
		newEncounter();
		boon.setupNewBoon();
	}
	
	public String encounterDescription() {		
		return this.path[pathTracker];
	}
	
	public void newEncounter() {
		encounter = new Encounter(encounterDescription());
		encounter.setupEncounter();
		this.pathTracker++; //every new encounter, moves path up one
		setDistanceLeft(); //every new encounter, caclculates a new distance
	}
	
	public void startCreatureBattle() {
		this.battle = new Battle (encounter.getCreature(), player);
	}
	
	public void startPlayerBattle() {
		this.battle = new Battle (player, encounter.getCreature());
	}
	
	public String implementBoon() {
		boon.implementBoon(player);
		String boonDescription = boon + "\n" + boon.getBoonType();
		boon.setupNewBoon(); //new boon is always setup after the old boon is used
		return boonDescription;
	}
	
	
	public void setDistanceLeft() {
		int distance = path.length - pathTracker;
		distance *= 10;
		distance -= 10;
		int randomBit = (int) (Math.random()*(9));
		distance += randomBit;
		this.distance = distance;
	}
	
	public Encounter getLook() {
		encounter.updateLooked();
		return encounter;
	}
	
	public int implementHeal() {
		int amount = player.healAmount();
		player.heal(amount);
		return amount;
	}
	
	public int creatureAttacks() {
		return battle.creatureAttack();
	}
	
	public int playerAttack (int attackType) {
		return battle.playerAttack(attackType);
	}
	
	public int getHit() {
		return this.hit;
	}
	
	public BattleStates creatureBattle() {
		startCreatureBattle();
		hit = creatureAttacks();
		if (hit == 0) {
			return BattleStates.MISS;
		}
		else {
			return BattleStates.DAMAGE;
		}
	}
	
	public BattleStates playerBattle(int attackType) {
		startPlayerBattle();
		hit = playerAttack(attackType);
		if (hit == 0) {
			return BattleStates.MISS;
		}
		else {
			return BattleStates.DAMAGE;
		}
	}
	

	public boolean areAlive() {
		if (player.isAlive() && getCurrentCreature().isAlive()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public EncounterType implementEncounter() {
		newEncounter();
		return encounter.getEncounterType();
	}
	
	public int determineAttackType(String attackTypeEntered) {
		int attackType = 0;
		if (Character.isDigit(attackTypeEntered.charAt(0))) { //checking to see if it is a digit
			attackType = Integer.parseInt(attackTypeEntered); //turning it into int
			if (attackType < 0 && attackType > 4) { //making sure it is in the ui menu range
				attackType = 1; //if not, automatically set to default (1)
			}
		}
		else { //if it isn't a digit
			attackType = 1; //set it to default(1)
		}
		return attackType;
	}
	
	@Override 
	public String toString() {
		return encounterDescription();
	}


}
