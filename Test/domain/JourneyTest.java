package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JourneyTest {

	@Test
	void journey_shares_journey_path() {
		Journey journey = new Journey();
		assertNull(journey.getPath()); //default path is null
		
		journey.setupJourney("C", "player");
		assertNotNull(journey.getPath()); //after setup path is no longer Null
	}
	
	@Test
	void journey_shares_pathTracker() {
		Journey journey = new Journey();
		assertEquals(-1, journey.getPathTracker()); //default pathTracker is -1
	}
	
	@Test
	void journey_shares_journeyType() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		assertEquals(JourneyType.SHORT, journey.getJourneyType()); 
		
		journey.setupJourney("M", "player");
		assertEquals(JourneyType.MEDIUM, journey.getJourneyType()); 
		
		journey.setupJourney("S", "player");
		assertEquals(JourneyType.LONG, journey.getJourneyType()); 
	}
	
	@Test
	void journey_shares_boon() {
		Journey journey = new Journey();
		assertTrue(journey.getBoon() instanceof Boon);
	}
	
	@Test
	void journey_shares_battle() {
		Journey journey = new Journey();
		assertNull(journey.getBattle()); //default state is null
	}
	
	@Test
	void journey_gets_most_recent_hit() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		journey.startCreatureBattle(); 
		int hit = journey.getHit();
		assertEquals(0, hit); //default is 0
	}
	
	@Test
	void journey_shares_distance() {
		Journey journey = new Journey();
		assertEquals(0, journey.getDistanceLeft()); //default distance is 0
	}
	
	@Test
	void journey_shares_creature() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		assertTrue(journey.getCurrentCreature() instanceof Creature);
	}
	
	@Test
	void journey_shares_player() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		assertTrue(journey.getPlayer().getName().equals("player"));
	}
	
	@Test
	void journey_shares_lookType() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		assertTrue(journey.getLookType() instanceof EncounterType);
	}
	
	@Test
	void journey_shares_alreadyLooked() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		assertFalse(journey.getAlreadyLooked()); //default is false
	}
	
	@Test
	void journey_shares_newCreature() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		Creature creature = journey.getCurrentCreature();
		Creature newCreature = journey.getNewCreature(); 
		assertFalse(creature.equals(newCreature)); //should be different creatures
	}
	
	@Test
	void journey_shares_if_game_is_over() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		assertFalse(journey.getIsOver()); //default is not over
	}
	
	@Test
	void journey_changes_if_game_is_over() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		journey.updateIsOver();
		assertTrue(journey.getIsOver()); //after updated, game should be over
	}
	
	@Test
	void journey_shares_encounter() {
		Journey journey = new Journey();
		assertNull(journey.getEncounter()); //default is Null
		
		journey.setupJourney("C", "player");
		assertTrue(journey.getEncounter() instanceof Encounter); //after setup should no longer be null
	}
	
	@Test
	void journey_sets_up_game() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		assertEquals(6, journey.getPath().length, "assert path"); //set up for C, should 6 steps
		assertTrue(journey.getPlayer().getName().equals("player"), "assert player"); //player is created with "player" name
		assertFalse(journey.getPlayer().getHitpoints() == 0, "assert hp"); //player should have more than 0 hitpoints
		assertEquals(1, journey.getPathTracker(), "assert tracker"); //path tracker is moved from -1 (default) to 1 aftersetup
		assertTrue(journey.getDistanceLeft() > 39, "assert distance"); //new path distance is calculated
		assertTrue(journey.getEncounter() instanceof Encounter , "assert encounter"); //after setup should no longer be null
		assertTrue(journey.getBoon() instanceof Boon, "assert Boon"); //new boon is created
	}
	
	@Test
	void journey_shares_encounter_description() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		String describe = journey.encounterDescription();
		assertEquals(describe.charAt(describe.length()-1), '.'); //last character should always be a period '.'
	}
	
	
	@Test
	void journey_gets_a_new_encounter() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		Encounter encounter = journey.getEncounter();
		journey.newEncounter();
		Encounter newEncounter = journey.getEncounter();
		assertFalse(encounter.equals(newEncounter)); //new encounter should not be the same as old encounter
		
		assertEquals(2, journey.getPathTracker()); //after new encounter pathtracker is increased, this case should be 2
		assertTrue(journey.getDistanceLeft() > 29, "assert distance"); //new path distance is calculated
	}
	
	@Test
	void journey_implements_boons() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		String describe = journey.implementBoon();
		assertEquals(describe.charAt(describe.length()-1), '.'); //last character should always be a period '.'		
	}
	
	@Test
	void journey_shares_distance_left() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");

		//path length = 6, path tracker = 1; distance = ((5*10) - 10) + randomNum(0-8)
		//distance will be between 40 - 48
		journey.setDistanceLeft();
		int distance = journey.getDistanceLeft();
		assertTrue(distance <= 49 && distance >= 40);
	}
	
	@Test
	void journey_shares_and_updates_looked() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		Encounter encounter = journey.getLook();
		assertEquals('Y', encounter.toString().charAt(0)); //all looks should start with 'Y'
		assertTrue(journey.getAlreadyLooked()); //now system should say we already looked
	}
	
	@Test
	void journey_implements_heal() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		int hp = journey.getPlayer().getHitpoints();
		int healAmount = journey.implementHeal();
		
		int newHp = journey.getPlayer().getHitpoints();
		assertTrue(healAmount >= 1 && healAmount <= 5); //implement shares heal amount
		assertTrue(newHp > hp); //new HP should be more than old HP	
	}
	
	@Test
	void journey_starts_new_creature_battle() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		assertNull(journey.getBattle()); //default state is null
		
		journey.startCreatureBattle(); //now the battle starts
		Battle battle = journey.getBattle();
		assertNotNull(battle); //battle is no longer null
		
		journey.startCreatureBattle(); //new battle starts
		Battle newBattle = journey.getBattle();
		assertFalse(battle.equals(newBattle)); //should not be the same battle
	}
	
	@Test
	void journey_starts_new_player_battle() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		assertNull(journey.getBattle()); //default state is null
		
		journey.startPlayerBattle(); //now the battle starts
		Battle battle = journey.getBattle();
		assertNotNull(battle); //battle is no longer null
		
		journey.startPlayerBattle(); //new battle starts
		Battle newBattle = journey.getBattle();
		assertFalse(battle.equals(newBattle)); //should not be the same battle
	}
	
	@Test
	void journey_implements_creature_battle() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		BattleStates state = journey.creatureBattle();
		Battle battle = journey.getBattle();
		assertNotNull(battle); //battle is no longer null
		assertTrue(state == BattleStates.DAMAGE || state == BattleStates.MISS); //state is one or the other
	}
	
	@Test
	void journey_implements_player_battle() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		BattleStates state = journey.playerBattle(1);
		Battle battle = journey.getBattle();
		assertNotNull(battle); //battle is no longer null
		assertTrue(state == BattleStates.DAMAGE || state == BattleStates.MISS); //state is one or the other
	}
	
	@Test
	void journey_checks_if_living() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		assertTrue(journey.areAlive()); //default should be alive
		
		Player player = journey.getPlayer();
		player.setHitpoints(0);
		player.checkDeath();
		assertFalse(journey.areAlive()); //one is dead it should be false
		
		Creature creature = journey.getCurrentCreature();
		creature.setHitpoints(0);
		creature.checkDeath();
		assertFalse(journey.areAlive()); //both are dead it should be false
	}
	
	@Test
	void journey_implements_encounters() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		Encounter encounter = journey.getEncounter();
		EncounterType type = journey.implementEncounter();
		Encounter newEncounter = journey.getEncounter();
		assertFalse(encounter.equals(newEncounter)); //new encounter should not be the same as old encounter
		
		assertEquals(2, journey.getPathTracker()); //after new encounter pathtracker is increased, this case should be 2
		assertTrue(journey.getDistanceLeft() > 29, "assert distance"); //new path distance is calculated
		assertTrue(type == EncounterType.NEGATIVE || type == EncounterType.NEUTRAL || type == EncounterType.POSITIVE);
	}

	@Test
	void journey_translates_player_input() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		int attack = journey.determineAttackType("1");
		assertEquals(1, attack);
		
		attack = journey.determineAttackType("b");
		assertEquals(1, attack); //if player enters a non-digit, it is translated as 1
		
		attack = journey.determineAttackType("6");
		assertEquals(1, attack); //if player enters a digit higher than 2, it is 1

		attack = journey.determineAttackType("2");
		assertEquals(2, attack); //if player enters a 2 it is 2
	}
	
	@Test
	void journey_shares_description_of_itself_via_string() {
		Journey journey = new Journey();
		journey.setupJourney("C", "player");
		
		String description = journey.toString();
		assertEquals(description.charAt(description.length()-1), '.'); //all journey segments end in '.'
	}
}

