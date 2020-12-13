package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoonTypeTest {

	@Test
	void bT_shares_appropriate_description_for_heal() {
		BoonType type = BoonType.HEAL;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("Your health has increased."));
	}
	
	@Test
	void bT_shares_appropriate_description_for_defense() {
		BoonType type = BoonType.DEFENSE;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("Your defense has increased."));
	}
	
	@Test
	void bT_shares_appropriate_description_for_attack() {
		BoonType type = BoonType.ATTACK;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("Your attack power has increased."));
	}


}
