package domain;

public class Controller {
	Journey journey;

	public Controller() {
		this.journey = new Journey();
	}
	
	public Journey getJourney() {
		return this.journey;
	}
	
	public Creature getCreature() {
		return journey.getCurrentCreature();
	}
	
	public Player getPlayer() {
		return journey.getPlayer();
	}
	
	public int getHit() {
		return journey.getHit();
	}
	
	public String getBoon() {
		return journey.implementBoon();
	}                         		  
	
	public EncounterType implementEncounter() {
		return journey.implementEncounter();
	}
	
	public BattleStates creatureBattleStates(Beings creature) {
		return journey.creatureBattle(creature);
	}
	
	public BattleStates playerBattleStates(int attackType) {
		return journey.playerBattle(attackType);
	}
	
	public int attackType(String attackTypeEntered) {
		return journey.determineAttackType(attackTypeEntered);
	}

}
