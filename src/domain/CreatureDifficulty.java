package domain;

public enum CreatureDifficulty {
	EASY{
		public String toString(){
			return "[weak]";
		}
	},
	MEDIUM {
		public String toString(){
			return "[average]";
		}
	},
	 HARD{
			public String toString(){
				return "[strong]";
			}
		}
}
