package domain;

public class Encounter {
	private String[] positiveLook = new String[] {
			"a bag of supplies that someone left behind.", "a small potion in a sparkling vial.",
			"a little old woman. She smiles and hands you a powerful tincture.", "a pouch of potent herbs.",
			"an inn where you can stay the night.", "a tiny cottage in the distance. The owner welcomes you in and gives you a hearty meal. ",
			"a small bronze good luck charm.", "a bitter, but powerful, elixir.", "a small child, who gives you a small good luck talisman.",
			"a place that would make the perfect campsite. You decide to rest a little.", "a tablet with blessing inscribed upon it."};

	private String[] neutralLook = new String[] {
			"a hawk circling in the distance.", "the remnants of an old hearth. It doesn’t look like it was used for many years.",
			"the outline of mountains in the far distance.", "dark rainclouds, which are fast approaching.",
			"a few snowflakes fluttering through the air.", "a coyote that is howling far in the distance.",
			"a traveler. He looks at you but says nothing.", "grass rustling in the wind.",
			"small field mice scurrying around a hollow log.", "a shepherd with a flock of sheep in the far distance.",
			"a farmer busy with his oxen. ", "women gathering water at a well. They ignore you.",
			"a bag that someone left behind. There is nothing of use for you."
	};
	
	private EncounterType type;
	private EncounterType look;
	private String description;
	private String whatDoYouSee;
	private Creature creature;
	private boolean alreadyLooked;

	public Encounter(String description) {
		this.type = null;
		this.description = description;
		this.creature = null;
		this.alreadyLooked = false;
	}
	
	public void setupEncounter() {
		typeOfEncounter();
		typeOfLook();
		lookDescription();
		this.creature = new Creature();
		creature.setupCreature();
	}
	
	public void lookDescription() {
		int randomSelector;
		if (look == EncounterType.POSITIVE) {
			randomSelector = (int) (Math.random()*this.positiveLook.length);
			this.whatDoYouSee = this.positiveLook[randomSelector];
		}
		else if(look == EncounterType.NEUTRAL) {
			randomSelector = (int) (Math.random()*this.neutralLook.length);
			this.whatDoYouSee = this.neutralLook[randomSelector];
		}
		else {
			this.whatDoYouSee = "Oh no! You caught the attention of an agressive creature.";
		}
	}
	
	public void typeOfEncounter() {
		int randomSelection = (int) (Math.random()*(10)+1);
		if (randomSelection == 10) {
			this.type = EncounterType.POSITIVE; 
		}
		else if(randomSelection == 8 || randomSelection == 9) {
			this.type = EncounterType.NEUTRAL;
		}
		else {
			this.type = EncounterType.NEGATIVE;
		}
	}
	
	public void typeOfLook() {
		int randomSelection = (int) (Math.random()*(4)+1);
		if (randomSelection == 1) {
			look = EncounterType.NEGATIVE; 
		}
		else if(randomSelection == 2) {
			look = EncounterType.POSITIVE;
		}
		else {
			look = EncounterType.NEUTRAL;
		}
	}
	
	public Creature getCreature() {
		return this.creature;
	}
	
	public EncounterType getEncounterType() {
		return this.type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean alreadyLooked() {
		return this.alreadyLooked;
	}
	
	
	@Override
	public String toString() {
		if(look == EncounterType.NEGATIVE) {
			return this.whatDoYouSee;
		}
		else {
			return "You look around and see " + this.whatDoYouSee; 
		}
	}

	public EncounterType getLookType() {
		return this.look;
	}

	public void updateLooked() {
		this.alreadyLooked = true;
	}
	

}
