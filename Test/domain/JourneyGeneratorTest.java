package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JourneyGeneratorTest {

	@Test
	void jG_shares_randomized_journey_component() {
		JourneyGenerator generator = new JourneyGenerator();
		String[] journeyComponent = new String[] {"first.", "second.", "third."};
		String journeySegment = generator.journeyRandomizer(journeyComponent);
		int length = journeySegment.length();
		assertEquals(journeySegment.charAt(length -1), '.');
	}
	
	@Test
	void jG_generates_full_journey() {
		JourneyGenerator generator = new JourneyGenerator();
		String[] journey = generator.getJourney(JourneyType.SHORT);
		assertEquals(journey.length, 6); //short journeys should have 6 segments
		
		journey = generator.getJourney(JourneyType.MEDIUM);
		assertEquals(journey.length, 11); //Medium journeys should have 11 segments
		
		 journey = generator.getJourney(JourneyType.LONG);
		assertEquals(journey.length, 16); //Long journeys should have 16 segments
	}
	
	@Test
	void jG_calculates_journey_length() {
		JourneyGenerator generator = new JourneyGenerator();
		int journey = generator.journeyLength(JourneyType.SHORT);
		assertEquals(journey, 6); //short journeys should have 6 segments
		
		journey = generator.journeyLength(JourneyType.MEDIUM);
		assertEquals(journey, 11); //Medium journeys should have 11 segments
		
		 journey = generator.journeyLength(JourneyType.LONG);
		assertEquals(journey, 16); //Long journeys should have 16 segments
	}
	
}
