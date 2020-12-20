package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControllerTest {

	@Test
	void controler_shares_journey() {
		Controller control = new Controller();
		assertTrue(control.getJourney() instanceof Journey);
	}
	
	@Test
	void controler_shares_creature() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		assertTrue(control.getCreature() instanceof Creature);
	}
	
	@Test
	void controler_shares_player() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		assertTrue(control.getPlayer() instanceof Player);
	}
	
	@Test
	void controler_shares_hit() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		Beings creature = journey.getCurrentCreature();
		journey.creatureBattle(creature);
		assertTrue(control.getHit() >= 0 && control.getHit() <= 6); //a creature attack should land between 0 - 6
	}
	
	@Test
	void controler_shares_boon() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		String boon = control.getBoon();
		String boon2 = control.getBoon(); //second time it is called, it should be a new boon
		assertFalse(boon.equals(boon2)); //boons should not equal
	}
	
	@Test
	void controler_shares_encounterType() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		assertTrue(control.implementEncounter() instanceof EncounterType);
	}
	
	@Test
	void controler_shares_creature_battle_state() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		Beings creature = journey.getCurrentCreature();
		assertTrue(control.creatureBattleStates(creature) instanceof BattleStates);
	}
	
	@Test
	void controler_shares_player_battle_state() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		assertTrue(control.playerBattleStates(1) instanceof BattleStates);
	}
	
	@Test
	void controler_shares_attack() {
		Controller control = new Controller();
		Journey journey = control.getJourney();
		journey.setupJourney("C", "player");
		int attack = control.attackType("1");
		assertEquals(1, attack);
	}
	

}
