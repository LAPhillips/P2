package domain;

public class Controller {
	Journey journey;

	public Controller() {
		this.journey = new Journey();
	}
	
	public Journey getJourney() {
		return this.journey;
	}
	
	public boolean attackOrBoon() {
		return journey.isAttack();
	}
	
	public Beings getCreature() {
		return journey.getCurrentCreature();
	}

}
