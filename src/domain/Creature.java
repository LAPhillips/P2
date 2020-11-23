package domain;

public class Creature implements Beings{
	private String name;
	private int hitpoints;
	private int baseAttack = 20;
	private int defense;
	private int currentHit;
	
	public Creature() {
		
	}
	
	public void generateName() {
		
	}

	
	
	public String getName() {
		
		return null;
	}

	@Override
	public void setHitpoints(int amount) {
		
	}

	@Override
	public int getHitpoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void attacked(int attackAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void damaged(int hitAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHitAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
