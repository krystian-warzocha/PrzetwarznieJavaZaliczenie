package finanse.baza;

public enum Wojewodztwo {
	
	DOL("Dolnoœl¹skie"),
	KUJPOM("Kujawsko-Pomorskie"),
	LODZ("£ódzkie"),
	LUBE("Lubekskie"),
	LUBU("Lubuskie"),
	MAL("Ma³opolskie"),
	MAZ("Mazowieckie"),
	OPOL("Opolskie"),
	PODK("Podkarpackie"),
	PODl("Podlaskie"),
	POM("Pomorskie"), 
	WARMAZ("Warmiñsko-Mazurskie"),
	WIEL("Wielkopolskie"),
	SLAS("Œl¹skie"),
	SWIE("Œwiêtokrzyskie"),
	ZACHPOM("Zachodnio-Pomorskie");
	
	String fullName;
	
	private Wojewodztwo(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return fullName;
	}

}
