package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomTenTest {

	@Test
	void random10_can_share_random_number() {
		RandomTen ten = new RandomTen();
		int number = ten.getRandomNumber();
		assertEquals(0, number); //default is 0
	}
	
	@Test
	void random10_can_generate_random_number() {
		RandomTen ten = new RandomTen();
		ten.generateNumber();
		int number = ten.getRandomNumber();
		assertTrue(number >= 1 && number <= 10);
	}
}
