package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreatureDifficultyTest {

	@Test
	void cD_shares_appropriate_description_for_easy() {
		CreatureDifficulty type = CreatureDifficulty.EASY;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("[weak]"));
	}
	
	@Test
	void cD_shares_appropriate_description_for_medium() {
		CreatureDifficulty type = CreatureDifficulty.MEDIUM;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("[average]"));
	}
	
	@Test
	void cD_shares_appropriate_description_for_hard() {
		CreatureDifficulty type = CreatureDifficulty.HARD;
		String typeToString = type.toString();
		assertTrue(typeToString.equals("[strong]"));
	}


}
