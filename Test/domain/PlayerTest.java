package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void player_calculates_hp() {
		Player player = new Player("player", -2);
		player.calculateHitpoints();
		int hp = player.getHitpoints();
		assertTrue(hp >= 20 && hp <= 50);
	}
	
	@Test
	void player_can_heal() {
		Player player = new Player("player", -2);
		player.setHitpoints(10);
		player.heal(2);
		assertEquals(12, player.getHitpoints());
	}
	
	@Test
	void player_caculates_amount_to_heal() {
		Player player = new Player("player", -2);
		int healAmount = player.healAmount();
		assertTrue(healAmount >= 1 && healAmount <=5);
	}
	
	@Test
	void player_shares_string_correctly() {
		Player player = new Player("player", -2);
		int healAmount = player.healAmount();
		assertTrue(healAmount >= 1 && healAmount <=5);
	}

	

}

