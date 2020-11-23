import domain.Creature;
import domain.CreatureDifficulty;
import domain.CreatureGenerator;

/**
 * 
 */

public class TaleOfNammu {

	public static void main(String[] args) {
		Creature creature = new Creature();
		
		creature.setRandomDifficulty();
		creature.setRandomName();
		
		System.out.println(creature.getDifficulty());
		System.out.println(creature.getName());


	}

}
