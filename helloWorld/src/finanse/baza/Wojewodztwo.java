package finanse.baza;

public enum Wojewodztwo {
	
	DOL("Dolno�l�skie"),
	KUJPOM("Kujawsko-Pomorskie"),
	LODZ("��dzkie"),
	LUBE("Lubekskie"),
	LUBU("Lubuskie"),
	MAL("Ma�opolskie"),
	MAZ("Mazowieckie"),
	OPOL("Opolskie"),
	PODK("Podkarpackie"),
	PODl("Podlaskie"),
	POM("Pomorskie"), 
	WARMAZ("Warmi�sko-Mazurskie"),
	WIEL("Wielkopolskie"),
	SLAS("�l�skie"),
	SWIE("�wi�tokrzyskie"),
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
