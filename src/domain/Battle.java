package domain;

public class Battle {
	private Beings attacker;
	private Beings defender;

	public Battle(Beings attacker, Beings defender) {
		this.attacker = attacker;
		this.defender = defender;
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
			int hit = caulculateDamage();
			defender.damaged(hit); //player takes damage
			checkDeath();
			return hit;
		}
		return 0;
	}
	
	public int playerAttack(int attackType) {
		if (isHit(attackType)) {
			int hit = caulculatePlayerDamage(attackType);
				defender.damaged(hit); //creature takes damage
				checkDeath();
				return hit;
			}	
		return 0;
	}

}
