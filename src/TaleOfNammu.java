import domain.CreatureDifficulty;
import domain.CreatureGenerator;

/**
 * 
 */

public class TaleOfNammu {

	public static void main(String[] args) {
		CreatureGenerator gen = new CreatureGenerator();
		gen.setCreatureDifficulty(1);
		System.out.println(gen.newCreatureName());
		
		gen.setCreatureDifficulty(2);
		System.out.println(gen.newCreatureName());
		
		gen.setCreatureDifficulty(3);
		System.out.println(gen.newCreatureName());
		


	}

}
