package domain;

public enum CreatureDifficulty {
	EASY{
		public String toString(){
			return "The beast looks quite weak.";
		}
	},
	MEDIUM {
		public String toString(){
			return "The beast looks average.";
		}
	},
	 HARD{
			public String toString(){
				return "The beast looks really strong.";
			}
		}
}
