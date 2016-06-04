package finanse.baza;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import finanse.domain.RodzajPaliwa;
import finanse.domain.RodzajSilnika;
import finanse.domain.Samochod;

public class BazaSamochodowTest {
	
	// SUT
	BazaSamochodow bs = new BazaImpl();
	
	final static String FORD = "Ford";
	final static String WARBURG = "Warburg";
	final static String GARBUS = "Garbus";
	final static String TRABANT = "Trabant";
	
	@Test
	public void szukajPoMarce() {
		Samochod w1 = new Samochod(WARBURG, RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY);
		Samochod w2 = new Samochod(WARBURG, RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY);
		Samochod w3 = new Samochod(WARBURG, RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY);
		
		Samochod g1 = new Samochod(GARBUS, RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY);
		Samochod g2 = new Samochod(GARBUS, RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY);
		
		Samochod t1 = new Samochod(TRABANT, RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY);
		Samochod t2 = new Samochod(TRABANT, RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY);
		
		bs.add(w1, Wojewodztwo.POM);
		bs.add(w2, Wojewodztwo.POM);
		bs.add(g1, Wojewodztwo.POM);
		bs.add(t1, Wojewodztwo.POM);
		
		bs.add(w3, Wojewodztwo.KUJPOM);
		bs.add(g2, Wojewodztwo.KUJPOM);
		bs.add(t2, Wojewodztwo.KUJPOM);
		
		List<Samochod> warburgi = bs.szukaj(WARBURG);
		assertEquals(3, warburgi.size());
		for(Samochod s : warburgi) {
			assertEquals(WARBURG, s.getMarka());
		}
		
		List<Samochod> garbusy = bs.szukaj(GARBUS);
		assertEquals(2, garbusy.size());
		for(Samochod s : garbusy) {
			assertEquals(GARBUS, s.getMarka());
		}
		
		List<Samochod> trabanty = bs.szukaj(TRABANT);
		assertEquals(2, trabanty.size());
		for(Samochod s : trabanty) {
			assertEquals(TRABANT, s.getMarka());
		}
		
		assertEquals(0, bs.szukaj(FORD).size());
	}
}
