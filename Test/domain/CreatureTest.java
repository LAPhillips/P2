package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreatureTest {


	@Test
	void creature_shares_name() {
		Creature creature = new Creature();
		String name = creature.getName();
		assertTrue(name.equals("noName")); //default is noName
	}
	
	@Test
	void creature_sets_name() {
		Creature creature = new Creature();
		creature.setName("newName");
		String name = creature.getName();
		assertTrue(name.equals("newName"));
	}
	
	@Test
	void creature_shares_Hitpoints() {
		Creature creature = new Creature();
		int hp = creature.getHitpoints();
		assertEquals(0, hp); //default is 0
	}
	
	@Test
	void creature_sets_Hitpoints() {
		Creature creature = new Creature();
		creature.setHitpoints(2);
		int hp = creature.getHitpoints();
		assertEquals(2, hp); 
	}
	
	@Test
	void creature_shares_baseAttack() {
		Creature creature = new Creature();
		int baseAttack = creature.getBaseAttack();
		assertEquals(20, baseAttack); //default is 20
	}

	@Test
	void creature_shares_defense() {
		Creature creature = new Creature();
		int defense = creature.getDefense();
		assertEquals(0, defense); 
	}
	
	@Test
	void creature_is_damaged() {
		Creature creature = new Creature();
		creature.setHitpoints(3); //creature has 3 hp
		creature.damaged(2); //creature is damaged for 2 points
		int hp = creature.getHitpoints(); 
		assertEquals(1, hp); //creature should creature 1
	}

	@Test
	void creature_getsRandomHP() {
		Creature creature = new Creature();
		creature.setRandomizedHitpoints();
		int hp = creature.getHitpoints();
		assertTrue(hp >= 1 && hp <= 30);
	}
	
	
	@Test
	void creature_attacks() {
		Creature creature = new Creature();
		creature.setupCreature();
		int attack = creature.attack();
		assertTrue(attack >= 1 && attack <= 7);
	}
	
	@Test
	void creature_should_be_created_in_a_single_step() {
		Creature creature = new Creature();
		creature.setupCreature();
		
		CreatureDifficulty difficulty = creature.getDifficulty();
		assertNotNull(difficulty); //make sure difficulty is set
	
		String name = creature.getName();
		assertFalse(name.equals("noName")); //make sure default name is changed
		
		int defense = creature.getDefense();
		assertFalse(defense == 0); //defense should not be equal to default 0
		
		int hp = creature.getHitpoints();
		assertFalse(hp == 0); //hp should not be equal to default 0
	}
	
	
	@Test
	void creature_prints_to_String() {
		Creature creature = new Creature();
		creature.setHitpoints(3); //creature has 3 hp
		creature.setRandomDefense();
		creature.setRandomDifficulty();
		String creatureToString = creature.getName() + " has 3 hit points, " + 
				creature.getDefense() + " defense";
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
