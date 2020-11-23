package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SageTest {

	@Test
	void sage_updates_hitpoints() {
		Sage sage = new Sage("sage");
		sage.calculateHitpoints();
		int hitpoints = sage.getHitpoints();
		assertTrue(hitpoints >= 20 && hitpoints <= 50);
	}
	
	@Test
	void sage_has_correct_defense() {
		Sage sage = new Sage("sage");
		int defense = sage.getDefense();
		assertEquals(-2, defense); //sage should have -2 defense
	}
	
	@Test
	void sage_can_heal_specific() {
		Sage sage = new Sage("sage");
		sage.setHitpoints(30); //setting hp at 30
		sage.heal(5); //using overloaded
		int hp = sage.getHitpoints();
		assertEquals(35, hp);
	}
	
	@Test
	void sage_can_heal_random() {
		Sage sage = new Sage("sage");
		sage.setHitpoints(30); //setting hp at 30
		sage.heal(); //using random
		int hp = sage.getHitpoints();
		assertTrue(hp >= 31 && hp <= 35);
	}

}
