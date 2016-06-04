package finanse.baza;

import java.util.List;

import finanse.domain.RodzajPaliwa;
import finanse.domain.RodzajSilnika;
import finanse.domain.Samochod;

public interface BazaSamochodow {
	
	public void add(Samochod s, Wojewodztwo w);
	
	public List<Samochod> szukaj(Wojewodztwo w);
	
	public List<Samochod> szukaj(String marka);
	
	public List<Samochod> szukaj(RodzajPaliwa rodzajPaliwa); 
	
	public List<Samochod> szukaj(RodzajSilnika rodzajSilnika);

}
