package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoonTest {

	@Test
	void boon_gets_current_boon() {
		Boon boon = new Boon();
		String currentBoon = boon.getCurrentBoon();
		assertTrue(currentBoon.equals(" ")); // default is " "
	}
	
	@Test
	void boon_gets_boonType() {
		Boon boon = new Boon();
		assertNull(boon.getBoonType()); // default is null
	}
	
	@Test
	void boon_gets_boonAmount() {
		Boon boon = new Boon();
		assertNull(boon.getBoonType()); // default is null
	}
	
	@Test
	void boon_sets_boonAmount() {
		Boon boon = new Boon();
		boon.setBoonAmount();
		int boonAmount = boon.getBoonAmount();
		assertTrue(boonAmount != 0); //once set boon should no longer be 0
	}

	@Test
	void boon_sets_currentBoon() {
		Boon boon = new Boon();
		boon.setCurrentBoon();
		String currentBoon = boon.getCurrentBoon();
		assertFalse(currentBoon.equals(" ")); // once set should no longer equal the default
	}
	
	@Test
	void boon_sets_up_new_boon() {
		Boon boon = new Boon();
		boon.setupNewBoon();
		
		String currentBoon = boon.getCurrentBoon();
		assertFalse(currentBoon.equals(" ")); // once set should no longer equal the default
		
		BoonType type = boon.getBoonType();
		assertTrue(type == BoonType.HEAL || type == BoonType.ATTACK || type == BoonType.DEFENSE);
		
		int boonAmount = boon.getBoonAmount();
		assertTrue(boonAmount >= 1 && boonAmount <= 6); //once set boon should no longer be 0
	}
	
	@Test
	void boon_applies_boon_to_player() {
		Boon boon = new Boon();
		Player player = new Player("name", -2);
		int heal = player.getHitpoints();
		int defense = player.getDefense();
		int bonus = player.getAttackBonus();
		
		boon.setupNewBoon();
		boon.implementBoon(player);
		
		//one of the following conditions should be true now
		assertTrue(heal != player.getHitpoints() ||	defense != player.getDefense() || bonus != player.getAttackBonus());
	}
	
	@Test
	void boon_selects_boonType() {
		Boon boon = new Boon();
		boon.setBoonType();
		BoonType type = boon.getBoonType();
		assertTrue(type == BoonType.HEAL || type == BoonType.ATTACK || type == BoonType.DEFENSE); //boon should be equal to one of the types
	}
	
}
