package domain;

public class JourneyGenerator {
	private final int SHORT = 6;
	private final int MEDIUM = 11;
	private final int LONG = 16;
	//you arrive at a  
	private String[] geographicFeature = new String[] {
			"a quiet stream flowing through the woods.",	"a dark cave. It looks dangerous.",
			"a grove of olive trees.", "a huge canyon that reaches out into the far distance.",
			"a small hill with several trees on top.", "the foot of a mountain, with ragged rocks jutting out.",
			"a still lake with fish swimming lazily among rocks.", "a yellow field of swaying barley.",
			"the outskirts of a small village.", "a vista with sand dunes.",
			"a small spring with trees circling it.", "a collection of boulders piled on top of one another.",
			"a wide valley dotted with farms.", "a deep river which you cannot cross, you will have to follow along side.",
			"a mountain pass with cliffs towering on either side of you.", "a dense, dark forest with twisted pines.",
			"the slopes of a mountain covered with a blanket of snow.", "herd of oxen wandering without anyone tending to them.",
			"red sandy desert that goes on and on...", "a small lake with brackish water.",
			"salt flats glimmering white in the sun.", "the charred remains of a house."};
	
	public JourneyGenerator() {
	}
	
	public String journeyRandomizer(String[] journeyComponent) {
		int index = (int) (Math.random()*(journeyComponent.length)-1);
		return journeyComponent[index];
	}

	public String[] getJourney(JourneyType type) {
		int length = journeyLength(type);
		String[] path = new String[length];
		for (int i = 0; i < length; i++) {
			path[i] = this.journeyRandomizer(this.geographicFeature);
		}
		return path;
	}
	
	public int journeyLength(JourneyType type) {
		switch(type) {
		case SHORT:
			return this.SHORT;
		case MEDIUM:
			return this.MEDIUM;
		case LONG:
			return this.LONG;
	}
		return 0;
	}
	
	
}
