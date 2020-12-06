package domain;

public class Boon {
	
	private String[] boon = new String[] {
			"An old sage comes your way and whispers a sacred incantation. After listening to it,",
			"On the ground you notice a small glittering vial. You recognize the vial is being a powerful tonic and after drinking it",
			"The goddess Innanna comes to you in a dream and tells you some secret information. After waking up ,",
			"You notice a beautiful rainbow in the sky. Anu has blessed you and",
			"At your foot, you notice a small copper talisman in the shape of a Lamassu. Upon putting it in your pocket,",
			"An old man, gray and wizened, approaches you and tells you the story of the Enuma Elis. After listening to it,",
			"In the distance you notice an inviting inn. You decide to rest there for the night. After waking up,",
			"As you walk, you see a young milk maid tending to some cows. She offers you some milk to help fortify you. After drinking it,",
			"You pass a wedding party on the road. Their singing fills you with joy and"
	};
	private BoonType type;
	private int boonAmount;
	private String currentBoon;

	public Boon() {
		this.type = null;
		this.boonAmount = 0;
		this.currentBoon = " ";
	}
	
	public String getCurrentBoon() {
		return this.currentBoon;
	}
	
	public BoonType getBoonType() {
		return this.type;
	}
	
	public int getBoonAmount() {
		return boonAmount;
	}
	
	public void setBoonAmount() {
		boonAmount = (int) (Math.random()*(5)+1);
	}
	
	public void setCurrentBoon() {
		int randomSelection = (int) (Math.random()*(boon.length));
		this.currentBoon = boon[randomSelection] + " you feel stronger.";
	}
	
	public void setupNewBoon() {
		setCurrentBoon();
		setBoonType();
		setBoonAmount();
	}
	
	public void implementBoon(Player player) {
		switch(type) {
		case HEAL:
			player.heal(boonAmount);
		case DEFENSE:
			int defense = player.getDefense();
			player.setDefense(defense - boonAmount);
		case ATTACK:
			player.setAttackBonus(boonAmount);
			}
	}
	
	public void setBoonType() {
		int randomSelection = (int) (Math.random()*(3)); 
		if (randomSelection == 0) {
			type = BoonType.HEAL;
		}
		else if (randomSelection == 1) {
			type = BoonType.DEFENSE;
		}
		else {
			type = BoonType.ATTACK;
		}
	}
	
}
