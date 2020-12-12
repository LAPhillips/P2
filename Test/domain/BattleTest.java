package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BattleTest {

	@Test
	void battle_checks_for_death() {
		Beings attacker = new Beings();
		Beings defender = new Beings();
		Battle battle = new Battle(attacker, defender);
		
		//since both beings were not setup, they should both be interpreted as dead
		//by checkDeath()
		battle.checkDeath(); 
		assertFalse(defender.isAlive() && attacker.isAlive());
		
		Creature attacker2 = new Creature();
		attacker2.setupCreature();
		Creature defender2 = new Creature();
		attacker2.setupCreature();
		Battle battle2 = new Battle(attacker, defender);
		
		//if they are given hitpoints, the game should not interpret them as dead
		battle.checkDeath();
		assertTrue(defender2.isAlive() && attacker2.isAlive());
	}
	
	@Test
	void battle_sees_if_attacker_hits_with_difficulty_level() {
		Creature attacker = new Creature();
		attacker.setupCreature();
		Creature defender = new Creature();
		defender.setupCreature();
		defender.setDefense(-20); //setting defense so low will make it impossible to hit
		Battle battle = new Battle(attacker, defender);
	
		assertFalse(battle.isHit(2));
		
		defender.setDefense(30); //setting defense so high will make it impossible to miss
		assertTrue(battle.isHit(2));
	}
	
	@Test
	void battle_sees_if_attacker_hits_without_difficulty_level() {
		Creature attacker = new Creature();
		attacker.setupCreature();
		Creature defender = new Creature();
		defender.setupCreature();
		defender.setDefense(-100); //setting defense so low will make it impossible to hit
		Battle battle = new Battle(attacker, defender);
	
		assertFalse(battle.isHit());
		
		defender.setDefense(100); //setting defense so high will make it impossible to miss
		assertTrue(battle.isHit());
	}
	
	@Test
	void battle_shares_amount_of_damage() {
		Creature attacker = new Creature();
		attacker.setupCreature();
		Creature defender = new Creature();
		defender.setupCreature();
		Battle battle = new Battle(attacker, defender);
		
		int damage = battle.caulculateDamage();
		assertTrue(damage >=1 && damage <= 7);
	}
	
	@Test
	void battle_shares_amount_of_damage_for_special_attacks() {
		Player attacker = new Player("player", -2);
		Creature defender = new Creature();
		defender.setupCreature();
		Battle battle = new Battle(attacker, defender);
		
		int damage = battle.caulculatePlayerDamage(2);
		assertTrue(damage >=3 && damage <= 13);
	}
	
	@Test
	void battle_conducts_creature_attack_and_shares_result() {
		Creature attacker = new Creature();
		attacker.setupCreature();
		Creature defender = new Creature();
		defender.setupCreature();
		defender.setDefense(100);//setting defense so high will make it impossible to miss
		Battle battle = new Battle(attacker, defender);
		
		int damage = battle.creatureAttack();
		assertFalse(damage == 0); //it should never return a 0, b/c it wont miss
	}
	
	@Test
	void battle_conducts_player_attack_and_shares_result() {
		Player attacker = new Player("player", -2);
		Creature defender = new Creature();
		defender.setupCreature();
		defender.setDefense(100);//setting defense so high will make it impossible to miss
		Battle battle = new Battle(attacker, defender);
		
		int damage = battle.playerAttack(1);
		assertFalse(damage == 0); //it should never return a 0, b/c it wont miss
	}


}
