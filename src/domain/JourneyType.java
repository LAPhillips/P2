package domain;

public enum JourneyType {
	SHORT {
		public String toString(){
			return "the Cedar Forest";
		}
	},
	MEDIUM {
		public String toString(){
			return "Mount Mashu";
		}
	},
	LONG {
		public String toString(){
			return "Salted Sea";
		}
	}
}
