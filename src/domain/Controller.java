package domain;

public class Controller {
	Journey journey;
	int hit;

	public Controller() {
		this.journey = new Journey();
		this.hit = 0;
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
	
	public BattleStates creatureBattleStates() {
		return journey.creatureBattle();
	}
	
	public BattleStates playerBattleStates(int attackType) {
		return journey.playerBattle(attackType);
	}
	
	public int attackType(String attackTypeEntered) {
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


}
