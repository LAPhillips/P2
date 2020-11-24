package domain;

public class Battleground {
//this is where the battles occur
	Creature creature;
	Player player;
	boolean turn;
	
	
	public Battleground(Creature monster, Player pc) {
		this.creature = monster;
		this.player = pc;
		boolean turn = true;
	}
	
	public int attackRoll() {
		return (int) (Math.random()*(20));
	}
	
	public void playerAttacked(int attack) {
		if( player.getBaseAttack() + player.getDefense() >= attackRoll()) { 	//does the player get hit?
			int hit = creature.attack(); //if yes, the creature calculates how much they hit for		
			player.damaged(hit); //player takes damage
		}
	}
	
	public void creatureAttacked(int attack) { //does the creature get hit?
		if (creature.getBaseAttack() + creature.getDefense() >= attackRoll()) { //if yes, the creature calculates how much they hit for	
			int hit = player.attack(); //creature takes damage
			creature.damaged(hit);
		}
	}
	
	public void updateTurn() {
		if (turn) {
			turn = false;
		}
		else {
			turn = true;
		}
	}

}
