package domain;

public interface Beings {
//share monster and player traits
	
	String getName();
	void setHitpoints(int amount);
	int getHitpoints();
	void attacked(int attackAmount);
	void damaged(int hitAmount);
	int getHitAmount();
}
