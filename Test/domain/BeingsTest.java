package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BeingsTest {

	@Test
	void beings_shares_name() {
		Beings be = new Beings("player", -2);
		String name = be.getName();
		assertTrue(name.equals("player"));
	}
	
	@Test
	void beings_sets_name() {
		Beings be = new Beings("player", -2);
		be.setName("newName");
		String name = be.getName();
		assertTrue(name.equals("newName"));
	}
	
	@Test
	void beings_shares_Hitpoints() {
		Beings be = new Beings("player", -2);
		int hp = be.getHitpoints();
		assertEquals(0, hp); //default is 0
	}
	
	@Test
	void beings_sets_Hitpoints() {
		Beings be = new Beings("player", -2);
		be.setHitpoints(2);
		int hp = be.getHitpoints();
		assertEquals(2, hp); 
	}
	
	@Test
	void beings_shares_baseAttack() {
		Beings be = new Beings("player", -2);
		int baseAttack = be.getBaseAttack();
		assertEquals(20, baseAttack); //default is 20
	}
	
	@Test
	void beings_shares_defense() {
		Beings be = new Beings("player", -2);
		int defense = be.getDefense();
		assertEquals(-2, defense); 
	}
	
	@Test
	void beings_sets_defense() {
		Beings be = new Beings("player", -2);
		int defense = be.getDefense();
		assertEquals(-2, defense); 
		
		be.setDefense(-4);
		defense = be.getDefense();
		assertEquals(-4, defense); 
		
	}

	@Test
	void beings_shares_attack() {
		Beings be = new Beings("player", -2);
		int attack = be.getAttackPoints();
		assertEquals(0, attack); //default is 0
	}
	
	@Test
	void beings_shares_attackBonus() {
		Beings be = new Beings("player", -2);
		int bonus = be.getAttackBonus();
		assertEquals(0, bonus); //default is 0
	}
	
	@Test
	void beings_sets_attackBonus() {
		Beings be = new Beings("player", -2);
		be.setAttackBonus(10);
		int bonus = be.getAttackBonus();
		assertEquals(10, bonus); //set Bonus should be 10
	}
	
	@Test
	void beings_shares_if_being_is_alive() {
		Beings be = new Beings("player", -2);
		assertTrue(be.isAlive()); //default is true
	}

	@Test
	void beings_calculates_damange() {
		Beings be = new Beings("player", -2);
		be.setHitpoints(3); //beings has 3 hp
		be.damaged(2); //beings is damaged for 2 points
		int hp = be.getHitpoints(); 
		assertEquals(1, hp); //beings should be 1
	}
	
	@Test
	void beings_shares_full_attack() {
		Beings be = new Beings("player", -2);
		int attack = be.attackAndShare();
		assertTrue(attack >= 1 && attack <= 7);
	}
	
	@Test
	void beings_sees_if_attack_is_Successful() {
		Beings be = new Beings("player", -2);
		int attackRating = be.seeIfAttack(); //default is random 0 - 20
		assertTrue(attackRating >= 0 && attackRating <= 20);
	}
	
	@Test
	void beings_adjusts_Difficulty_to_see_if_attack_is_Successful() {
		Beings be = new Beings("player", -2);
		int attackRating = be.seeIfAttack(1); //default is random 0 - 20
		assertTrue(attackRating >= 0 && attackRating <= 20);
		
		attackRating = be.seeIfAttack(2); //higher difficulty hitting for #2
		assertTrue(attackRating >= 4 && attackRating <= 24);
	}
	
	@Test
	void beings_checks_to_see_if_it_is_alive() {
		Beings be = new Beings("player", -2);
		assertTrue(be.isAlive()); //beings are always alive by default
		be.checkDeath();
		assertFalse(be.isAlive()); //default hp is 0, so if we check before setup, player should be marked as dead
	}
	
}
