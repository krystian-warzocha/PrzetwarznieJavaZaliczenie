package finanse.kolekcje;

public enum DzienTygodnia {
	PON("Poniedziałek"), 
	WTO("Wtorek"), 
	SRO("Śroka"), 
	CZW("Czwartek"), 
	PI("Piątek"), 
	SO("Sobota"), 
	NI("Niedziela");
	
	private String fullName;
	private DzienTygodnia(String fullName){
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return fullName;
	}
}
