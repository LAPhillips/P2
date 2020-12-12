package domain;

public class Battle {
	private Beings attacker;
	private Beings defender;
	private int mostRecentHit;

	public Battle(Beings attacker, Beings defender) {
		this.attacker = attacker;
		this.defender = defender;
		this.mostRecentHit = 0;
	}
	
	public int getMostRecentHit() {
		return this.mostRecentHit;
	}
	
	public void checkDeath() {
		attacker.checkDeath();
		defender.checkDeath();
	}
	
	public boolean isHit(int levelOfDifficulty) {
		int attackRoll = attacker.seeIfAttack(levelOfDifficulty);
		if (defender.getBaseAttack() + defender.getDefense() >= attackRoll) {
			return true;
		}
		return false;
	}
	
	public boolean isHit() {
		int attackRoll = attacker.seeIfAttack();
		if (defender.getBaseAttack() + defender.getDefense() >= attackRoll) {
			return true;
		}
		return false;
	}
	
	public int caulculateDamage() {
		return attacker.attackAndShare(); // the creature calculates how much they hit for
	}
	
	public int caulculatePlayerDamage(int attackType) {
		Player player = (Player) attacker;
		return player.attackAndShare(attackType); // the creature calculates how much they hit for
	}
	
	public int creatureAttack() {
		if (isHit()) {
			this.mostRecentHit = caulculateDamage();
			defender.damaged(mostRecentHit); //player takes damage
			checkDeath();
		}
		else {
			mostRecentHit = 0;
		}
		return mostRecentHit;
	}
	
	public int playerAttack(int attackType) {
		if (isHit(attackType)) {
			mostRecentHit = caulculatePlayerDamage(attackType);
			defender.damaged(mostRecentHit); //creature takes damage
			checkDeath();
			}	
		else {
			mostRecentHit = 0;
		}
		return mostRecentHit;
	}
	
	public BattleStates creatureBattleState() {	
		int hit = creatureAttack();
		if (hit == 0) {
			return BattleStates.MISS;
		}
		else {
			return BattleStates.DAMAGE;
		}
	}
	
	public BattleStates playerBattleState(int attackType) {
		int hit = playerAttack(attackType);
		if (hit == 0) {
			return BattleStates.MISS;
		}
		else {
			return BattleStates.DAMAGE;
		}
	}
	
	

}
