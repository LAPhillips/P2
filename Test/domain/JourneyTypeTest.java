package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JourneyTypeTest {

	@Test
	void jT_shares_appropriate_description_for_short() {
		JourneyType type = JourneyType.SHORT;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("the Cedar Forest"));
	}
	
	@Test
	void jT_shares_appropriate_description_for_Medium() {
		JourneyType type = JourneyType.MEDIUM;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("Mount Mashu"));
	}
	
	@Test
	void jT_shares_appropriate_description_for_long() {
		JourneyType type = JourneyType.LONG;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("Salted Sea"));
	}

}
