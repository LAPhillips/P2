package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JourneyGeneratorTest {
	
	@Test
	void jG_shares_JourneyType() {
		JourneyGenerator generator = new JourneyGenerator();
		assertNull(generator.getJourneyType()); //default type should be null
	}
	
	@Test 
	void jG_shares_journey_in_one_method(){
		JourneyGenerator generator = new JourneyGenerator();
		
		String[] journey = generator.implementJourney("C");
		assertEquals(6, journey.length); //short journeys should have 6 segments
		
		journey = generator.implementJourney("M");
		assertEquals(11, journey.length); //Medium journeys should have 11 segments
		
		journey = generator.implementJourney("S");
		assertEquals(16, journey.length); //Long journeys should have 16 segments
		
		
	}

	@Test
	void jG_sets_journeyType_based_on_input() {
		JourneyGenerator generator = new JourneyGenerator();
		
		generator.journeyChoice("C");
		assertEquals(JourneyType.SHORT, generator.getJourneyType());
		
		generator.journeyChoice("M");
		assertEquals(JourneyType.MEDIUM, generator.getJourneyType());
		
		generator.journeyChoice("S");
		assertEquals(JourneyType.LONG, generator.getJourneyType());
	}
	
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
		
		generator.journeyChoice("C");
		String[] journey = generator.getJourney();
		assertEquals(6, journey.length); //short journeys should have 6 segments
		
		generator.journeyChoice("M");
		journey = generator.getJourney();
		assertEquals(11, journey.length); //Medium journeys should have 11 segments
		
		generator.journeyChoice("L");
		 journey = generator.getJourney();
		assertEquals(16, journey.length); //Long journeys should have 16 segments
	}
	
	@Test
	void jG_calculates_journey_length() {
		JourneyGenerator generator = new JourneyGenerator();
		
		generator.journeyChoice("C");
		int journey = generator.journeyLength();
		assertEquals(6, journey); //short journeys should have 6 segments
		
		generator.journeyChoice("M");
		journey = generator.journeyLength();
		assertEquals(11,journey); //Medium journeys should have 11 segments
		
		generator.journeyChoice("S");
		journey = generator.journeyLength();
		assertEquals(16,journey); //Long journeys should have 16 segments
	}
	

	
}
