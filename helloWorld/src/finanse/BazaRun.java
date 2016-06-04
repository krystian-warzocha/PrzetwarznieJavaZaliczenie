package finanse;

import finanse.baza.BazaImpl;
import finanse.baza.BazaSamochodow;
import finanse.baza.Wojewodztwo;
import finanse.domain.RodzajPaliwa;
import finanse.domain.RodzajSilnika;
import finanse.domain.Samochod;

public class BazaRun {

	public static void main(String[] args) {
		BazaSamochodow bs = new BazaImpl();	
		
		bs.add(new Samochod("Warburg", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY), Wojewodztwo.KUJPOM);
		bs.add(new Samochod("Trabant", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY), Wojewodztwo.KUJPOM);
		
		bs.add(new Samochod("Warburg", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY), Wojewodztwo.POM);
		bs.add(new Samochod("Trabant", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY), Wojewodztwo.POM);
		
		System.out.println(bs.szukaj("Warburg"));

	}

}
