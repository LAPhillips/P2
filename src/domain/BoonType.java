package domain;

public enum BoonType {
	HEAL{
		public String toString(){
			return "Your health has increased.";
		}
	},
	DEFENSE{
		public String toString(){
			return "Your defense has increased.";
		}
	},
	ATTACK{
		public String toString(){
			return "Your attack power has increased.";
		}
	}
}
