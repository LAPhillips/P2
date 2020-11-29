package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void player_can_heal() {
		Player player = new Player("player", -2);
		player.setHitpoints(10);
		player.heal(2);
		assertEquals(12, player.getHitpoints());
	}

}

