import domain.Battleground;
import domain.Creature;
import domain.CreatureDifficulty;
import domain.CreatureGenerator;
import domain.Player;

/**
 * 
 */

public class TaleOfNammu {

	public static void main(String[] args) {
		Creature creature = new Creature();
		creature.setupCreature();
		Player player = new Player("Tim", -2);
		player.calculateHitpoints();
		Battleground ground = new Battleground(creature, player);

		System.out.println(player);
		System.out.println(creature);

		
		ground.playerAttacked(12);
		ground.creatureAttacked(12);
		
		System.out.println(player);
		System.out.println(creature);
	}

}
