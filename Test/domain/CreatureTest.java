package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreatureTest {

	@Test
	void creature_should_be_created_in_a_single_step() {
		Creature creature = new Creature();
		creature.setupCreature();
		
		CreatureDifficulty difficulty = creature.getDifficulty();
		assertNotNull(difficulty); //make sure difficulty is set
	
		String name = creature.getName();
		assertFalse(name.equals("noName"), "second assert"); //make sure default name is changed
		
		int defense = creature.getDefense();
		assertFalse(defense == 1 , "third assert"); //defense should not be equal to default 0
		
		int hp = creature.getHitpoints();
		assertFalse(hp == 0, "fourth assert"); //hp should not be equal to default 0
	}
	
	
	@Test
	void creature_prints_to_String() {
		Creature creature = new Creature();
		creature.setHitpoints(3); //creature has 3 hp
		creature.setRandomDefense();
		creature.setRandomDifficulty();
		String creatureToString = creature.getName();
		assertTrue(creature.toString().equals(creatureToString));
	}

	@Test
	void creature_sets_random_Name() {
		Creature creature = new Creature();
		creature.setRandomName();
		String name = creature.getName();
		assertNotNull(name);
	}
	
	@Test
	void creature_sets_random_Defense() {
		Creature creature = new Creature();
		creature.setRandomDefense();
		int defense = creature.getDefense();
		assertTrue(defense >= -90 && defense <= 0);
	}
	
	@Test void creature_gets_Difficulty() {
		Creature creature = new Creature();
		CreatureDifficulty difficulty = creature.getDifficulty();
		assertEquals(null, difficulty); //default diffulty is null
	}
	
	@Test void creature_sets_random_Difficulty() {
		Creature creature = new Creature();
		creature.setRandomDifficulty();
		CreatureDifficulty difficulty = creature.getDifficulty();
		assertTrue(difficulty == CreatureDifficulty.EASY || 
				difficulty == CreatureDifficulty.MEDIUM ||
				difficulty == CreatureDifficulty.HARD); 
	}
	
	
	
}
