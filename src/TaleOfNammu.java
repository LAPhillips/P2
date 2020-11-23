import domain.Creature;
import domain.CreatureDifficulty;
import domain.CreatureGenerator;

/**
 * 
 */

public class TaleOfNammu {

	public static void main(String[] args) {
		Creature creature = new Creature();
		
		creature.setupCreature();
		System.out.println(creature);


	}

}
