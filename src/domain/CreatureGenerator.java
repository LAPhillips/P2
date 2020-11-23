package domain;

public class CreatureGenerator {
	
	private String[] hardCreatures = new String[] {"Adventurous", "Agile", "Assertive", "Abnormal",
			"Aggressive","Brilliant", "Caustic", "Charming", "Clever", "Cruel", "Deft", "Demonic", "Dire", "Egotistical", "Ferocious",
			"Fiery", "Great", "Hateful","Impetuous", "Independent", "Powerful", "Quick", "Spiteful", "Stern", "Shrewd",
			"Soulless", "Spirited", "Stoic", "Strong", "Immortal", "Fearsome", "Nameless", "Huge", "Horrendous", "Deadly",
			"Hideous", "Towering", "Grotesque", "Evil", "Dire", "Vicious", "Remorseless", "Proud", "Frenzied", 
			"Bloodthirsty", "Jeweled", "Jaded"};
	private String[] mediumCreatures = new String[] {"Average", "Awful", "Ardent", "Attentive", 
			"Brave", "Callous", "Courageous", "Crabby", "Cranky", "Confident", "Crafty", "Crass", "Dutiful",
			"Decisive", "Depressed", "Dirty", "Disruptive", "Evasive", "Energetic", "Enthusiastic", "Fastidious", "Intelligent",
			"Gloomy", "Grouchy", "Irritating", "Irritable", "Judgmental", "Mean", "Miserable", "Nasty", "Persnickety", "Resourceful",
			"Restless", "Resentful", "Serious", "Somber", "Sour", "Surly", "Ugly", "Uncooperative", "Unemotional",
			"Unpleasant","Reckless", "Haggard"};
	private String[] easyCreatures = new String[] {"Apprehensive", "Absent-minded", "Apathetic", "Boring", 
			"Careful", "Clumsy", "Confused", "Curious", "Careless", "Cautious", "Churlish",
			"Cowardly", "Distrustful", "Delicate", "Dreary", "Flaky", "Oozing",
			"Flabby", "Fussy", "Guarded", "Hesitant", "Immature", "Impatient", "Impressionable",
			"Inconsiderate", "Incompetent", "Inexperienced", "Lethargic", "Lazy", "Morose", "Obnoxious", "Stinking",
			"Plain", "Pensive", "Quiet", "Reclusive", "Reserved", "Sad", "Shy", "Slow", "Sensitive", "Tired", "Timid",
			"Uncertain", "Unmotivated", "Unsure", "Vulnerable", "Wary", "Weak"};
	private String[] typesOfCreatures = new String[] {"Djinn", "Udug", "Lamassu (Winged Bull)", "Alal (Lion-headed Man)",
			"Hyena", "Lion", "Dog", "Eagle", "Scorpion", "Snake", "Ghost", "Wolf", "Harpy", "Serpent", "Ghoul",
			"Ifrit", "Rukh", "Leopard", "Giant", "Bat", "Bear", "Caracal", "Toad",
			"Viper", "Crocodile", "Spider", "Anzu (Fire-breathing Bird)", "Dragon", "Manticore", "Basilisk", "Sphinx", "Chimera", "Almiraj"};
	private CreatureDifficulty difficulty;
	
	public CreatureGenerator() {
		this.difficulty = CreatureDifficulty.EASY;	
	}
	
	public CreatureDifficulty getDifficulty() {
		return this.difficulty;
	}
	
	public void setCreatureDifficulty(int difficultyRating) {
		if (difficultyRating == 2) {
			this.difficulty = CreatureDifficulty.MEDIUM;
		}
		else if (difficultyRating == 3) {
			this.difficulty = CreatureDifficulty.HARD;
		}
		else {
			this.difficulty = CreatureDifficulty.EASY;
		}
	}
	
	public String newCreatureName() {
		int attributeIndex = attributeType();
		int creatureTypeIndex = (int) ((Math.random()*(typesOfCreatures.length))-1);
		String newCreatureName = createCreatureName(attributeIndex, creatureTypeIndex);
		return newCreatureName;
	}
	
	public int attributeType() {
		int attributeIndex = 0;
		switch(this.difficulty) {
		case EASY:
			attributeIndex = (int) ((Math.random()*(easyCreatures.length)) -1);
			break;
		case MEDIUM:
			attributeIndex = (int) ((Math.random()*(mediumCreatures.length)) -1);
			break;
		case HARD:
			attributeIndex = (int) ((Math.random()*(hardCreatures.length)) -1);
			break;
		}	
		return attributeIndex;
	}
	
	
	public String createCreatureName(int attribute, int creatureType) {
		String creatureName = " ";
		switch(this.difficulty) {
		case EASY:
			creatureName = easyCreatures[attribute] + " " + typesOfCreatures[creatureType];
			break;
		case MEDIUM:
			creatureName = mediumCreatures[attribute] + " " + typesOfCreatures[creatureType];
			break;
		case HARD:
			creatureName = hardCreatures[attribute] + " " + typesOfCreatures[creatureType];
			break;
		}
		return creatureName;
	}
	
	

}
