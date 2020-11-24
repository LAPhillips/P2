package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreatureGeneratorTest {

	@Test
	void cG_gets_difficulty() {
		CreatureGenerator gen = new CreatureGenerator();
		CreatureDifficulty difficulty = gen.getDifficulty();
		assertEquals(CreatureDifficulty.EASY, difficulty); //default is EASY
	}
	
	@Test
	void cG_sets_difficulty() {
		CreatureGenerator gen = new CreatureGenerator();
		gen.setCreatureDifficulty(2);
		CreatureDifficulty difficulty = gen.getDifficulty();
		assertEquals(CreatureDifficulty.MEDIUM, difficulty); //2 is MEDIUM
		
		gen.setCreatureDifficulty(3);
		difficulty = gen.getDifficulty();
		assertEquals(CreatureDifficulty.HARD, difficulty); //3 is HARD
		
		gen.setCreatureDifficulty(1);
		difficulty = gen.getDifficulty();
		assertEquals(CreatureDifficulty.EASY, difficulty); //1 is EASY	
	}
	
	@Test
	void cG_picks_attribute_index() {
		CreatureGenerator gen = new CreatureGenerator();
		gen.setCreatureDifficulty(3);
		int index = gen.attributeType();
		assertTrue(index >= 0 && index <= 47); //index count should fall between 0 - 47
		
		gen.setCreatureDifficulty(2);
		index = gen.attributeType();
		assertTrue(index >= 0 && index <= 42); //index should fall between 0 - 43
		
		gen.setCreatureDifficulty(1);
		index = gen.attributeType();
		assertTrue(index >= 0 && index <= 48); //index should fall between 0 - 48	
	}
	
	@Test
	void cG_creates_random_creature_name() {
		CreatureGenerator gen = new CreatureGenerator();
		gen.setCreatureDifficulty(3);
		String creature = gen.createCreatureName(2, 1);
		assertTrue(creature.equals("Assertive Udug"));
		
		gen.setCreatureDifficulty(2);
		creature = gen.createCreatureName(2, 0);
		assertTrue(creature.equals("Ardent Djinn"));
		
		gen.setCreatureDifficulty(1);
		creature = gen.createCreatureName(3, 4);
		assertTrue(creature.equals("Boring Hyena"));
	}
	
	@Test
	void cG_complete_creature_name_creation() {
		CreatureGenerator gen = new CreatureGenerator();
		gen.setCreatureDifficulty(3);
		String creature = gen.newCreatureName();
		assertNotNull(creature); //can't really test out all variations, but make sure it is not null
	}
	
	@Test
	void cG_gets_random_difficulty() {
		CreatureGenerator gen = new CreatureGenerator();
		int difficulty = gen.randomizeDifficulty();
		assertTrue(difficulty >= 1 && difficulty <= 3);
		}
	
	@Test
	void cG_sets_random_difficulty() {
		CreatureGenerator gen = new CreatureGenerator();
		CreatureDifficulty difficulty = gen.generateDifficulty();
		assertTrue(difficulty == CreatureDifficulty.EASY || 
				difficulty == CreatureDifficulty.MEDIUM || 
				difficulty == CreatureDifficulty.HARD);
		}
	
	@Test
	void cG_generates_hit_points() {
		CreatureGenerator gen = new CreatureGenerator();
		gen.setCreatureDifficulty(3);
		int hp = gen.getRandomizedHitPoints();
		assertTrue(hp >= 10 && hp <= 30, "first"); //hp should fall between 10 and 30
		
		gen.setCreatureDifficulty(2);
		hp = gen.getRandomizedHitPoints();
		assertTrue(hp >= 2 && hp <= 12, "second"); //hp should fall between 2 and 12
		
		gen.setCreatureDifficulty(1);
		hp = gen.getRandomizedHitPoints();
		assertTrue(hp >= 1 && hp <= 6, "third"); //hp should fall between 1 and 6	
	}
	
	@Test
	void cG_generates_defense() {
		CreatureGenerator gen = new CreatureGenerator();
		gen.setCreatureDifficulty(3);
		int def = gen.generateDefense();
		assertTrue(def >= -9 && def <= -2, "first"); //def should fall between -9 and -2
		
		gen.setCreatureDifficulty(2);
		def = gen.generateDefense();
		assertTrue(def >= -6 && def <= -1, "second"); //def should fall between -6 and -1
		
		gen.setCreatureDifficulty(1);
		def = gen.generateDefense();
		assertTrue(def >= -2 && def <= 0, "third"); //def should fall between -1 and 0
	}
	

}
