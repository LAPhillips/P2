package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumbersTest {

	@Test
	void random10_can_share_random_number() {
		RandomNumbers random = new RandomNumbers();
		int number = random.getRandomNumber();
		assertEquals(0, number); //default is 0
	}
	
	@Test
	void random_can_generate_random_number_from_1_5() {
		RandomNumbers random = new RandomNumbers();
		random.generateRandomFive();
		int number = random.getRandomNumber();
		assertTrue(number >= 1 && number <= 5);
	}
	
	@Test
	void random_can_generate_random_number_from_1_10() {
		RandomNumbers random = new RandomNumbers();
		random.generateRandomTen();
		int number = random.getRandomNumber();
		assertTrue(number >= 1 && number <= 10);
	}
	
	@Test
	void random_can_generate_random_number_from_1_20() {
		RandomNumbers random = new RandomNumbers();
		random.generateRandomTwenty();
		int number = random.getRandomNumber();
		assertTrue(number >= 1 && number <= 20);
	}
	
	@Test
	void random_can_generate_random_number_bespoke() {
		RandomNumbers random = new RandomNumbers();
		random.generateRandom(1,2);
		int number = random.getRandomNumber();
		assertTrue(number >= 1 && number <= 2);
	}
	
	@Test
	void random10_can_set_specific_numbers_too() {
		RandomNumbers random = new RandomNumbers();
		random.setNumber(10);
		int number = random.getRandomNumber();
		assertTrue(number == 10);
	}
}
