package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncounterTest {

	@Test
	void encounter_shares_associated_creature() {
		Encounter encounter = new Encounter("description");
		assertNull(encounter.getCreature()); //default creature is null
	}
	
	@Test
	void encounter_shares_encounterType() {
		Encounter encounter = new Encounter("description");
		assertNull(encounter.getEncounterType()); //default type is null
	}
	
	@Test
	void encounter_shares_description() {
		Encounter encounter = new Encounter("description");
		assertTrue(encounter.getDescription().equals("description")); //default is the description entered while creating
	}
	
	@Test
	void encounter_shares_if_player_looked() {
		Encounter encounter = new Encounter("description");
		assertFalse(encounter.alreadyLooked()); //default type is false 
	}
	
	@Test
	void encounter_shares_lookType() {
		Encounter encounter = new Encounter("description");
		assertNull(encounter.getLookType()); //default type is Null
	}
	
	@Test
	void encounter_updates_Look() {
		Encounter encounter = new Encounter("description");
		encounter.updateLooked();
		assertTrue(encounter.alreadyLooked()); //after updated should be true
	}
	
	@Test
	void encounter_shares_lookDescription() {
		Encounter encounter = new Encounter("description");
		assertTrue(encounter.getLookDescription().equals(" "));
	}
	
	@Test
	void encounter_provides_look_description() {
		Encounter encounter = new Encounter("description");
		encounter.lookDescription();
		assertFalse(encounter.getLookDescription().equals(" ")); //should no longer be default " "
	}
	
	@Test
	void encounter_creates_new_creature() {
		Encounter encounter = new Encounter("description");
		Creature creature2 = encounter.getNewCreature();
		assertNotNull(creature2);
	}
	
	@Test
	void encounter_picks_encounterType() {
		Encounter encounter = new Encounter("description");
		encounter.typeOfEncounter();
		EncounterType type = encounter.getEncounterType();
		assertTrue(type == EncounterType.POSITIVE || type == EncounterType.NEGATIVE ||
				type == EncounterType.NEUTRAL); //encounter type must be one of the three
	}
	
	@Test
	void encounter_picks_lookType() {
		Encounter encounter = new Encounter("description");
		encounter.typeOfLook();
		EncounterType type = encounter.getLookType();
		assertTrue(type == EncounterType.POSITIVE || type == EncounterType.NEGATIVE ||
				type == EncounterType.NEUTRAL); //encounter type must be one of the three
	}
	
	@Test
	void encounter_sets_itself_up() {
		Encounter encounter = new Encounter("description");
		encounter.setupEncounter();
		
		EncounterType type = encounter.getEncounterType();
		assertTrue(type == EncounterType.POSITIVE || type == EncounterType.NEGATIVE ||
				type == EncounterType.NEUTRAL); //encounter type must be one of the three
		
		encounter.typeOfLook();
		EncounterType type2 = encounter.getLookType();
		assertTrue(type2 == EncounterType.POSITIVE || type2 == EncounterType.NEGATIVE ||
				type2 == EncounterType.NEUTRAL); //encounter type must be one of the three
		
		assertFalse(encounter.getLookDescription().equals(" ")); //should no longer be default " "
		assertNotNull(encounter.getCreature());
		assertTrue(encounter.getCreature().getHitpoints() != 0); //after setup Creature should have more than 0 hp
	}
	
	@Test
	void encounter_shares_a_string() {
		Encounter encounter = new Encounter("description");
		String description = encounter.toString();
		assertTrue(description.charAt(0) == 'Y'); //to string always starts with 'Y'
	}

}
