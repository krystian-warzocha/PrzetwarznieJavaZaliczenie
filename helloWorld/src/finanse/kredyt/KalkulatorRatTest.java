package finanse.kredyt;

import static org.junit.Assert.*;

import org.junit.Test;

import finanse.kredyt.KalkulatorRat.ProwizjaTyp;
import finanse.kredyt.KalkulatorRat.RodzajRatTyp;

public class KalkulatorRatTest {
	
	// SUT
	KalkulatorRat kr = new KalkulatorRat();
	
	@Test
	public void testObliczen() {
		// Expected 
		RezultatRaty expected = new RezultatRaty(3000, 203000, 200000, 223257.49);
		
		// Actual
		RezultatRaty actual = kr.oblicz(200000, ProwizjaTyp.POWIEKSZA, 1.5, 7.5, 30, RodzajRatTyp.ROWNE);
		
		assertEquals(expected.getProwizja(), actual.getProwizja(), 1e-2);
		assertEquals(expected.getKwotaKredytowania(), actual.getKwotaKredytowania(), 1e-2);
		assertEquals(expected.getKwotaDoWyplaty(), actual.getKwotaDoWyplaty(), 1e-2);
		assertEquals(expected.getSumaSplat(), actual.getSumaSplat(), 1e-2);
	}
	
	@Test
	public void testRatMalejacych() {
		// Expected
		RezultatRaty expected = new RezultatRaty(0, 200000, 200000, 219375.00);
		
		// Actual
		RezultatRaty actual = kr.oblicz(200000, ProwizjaTyp.NIE_UWZGLEDNIAJ, 1.5, 7.5, 30, RodzajRatTyp.MALEJACE);
		
		assertEquals(expected.getProwizja(), actual.getProwizja(), 1e-2);
		assertEquals(expected.getKwotaKredytowania(), actual.getKwotaKredytowania(), 1e-2);
		assertEquals(expected.getKwotaDoWyplaty(), actual.getKwotaDoWyplaty(), 1e-2);
		assertEquals(expected.getSumaSplat(), actual.getSumaSplat(), 1e-2);
	}
	
	@Test
	public void testProwizjaZmniejsza() {
		// Expected
		RezultatRaty expected = new RezultatRaty(3000, 200000, 197000, 219375.0);
		
		// Actual
		RezultatRaty actual = kr.oblicz(200000, ProwizjaTyp.POMNIEJSZA, 1.5, 7.5, 30, RodzajRatTyp.MALEJACE);
		
		assertEquals(expected.getProwizja(), actual.getProwizja(), 1e-2);
		assertEquals(expected.getKwotaKredytowania(), actual.getKwotaKredytowania(), 1e-2);
		assertEquals(expected.getKwotaDoWyplaty(), actual.getKwotaDoWyplaty(), 1e-2);
		assertEquals(expected.getSumaSplat(), actual.getSumaSplat(), 1e-2);
	}
	
	@Test
	public void testProwizjaOsobno() {
		// Expected
		RezultatRaty expected = new RezultatRaty(7500, 300000, 300000, 343263.36);
		
		// Actual
		RezultatRaty actual = kr.oblicz(300000, ProwizjaTyp.ZAPLACONO, 2.5, 6.5, 50, RodzajRatTyp.ROWNE);
		
		assertEquals(expected.getProwizja(), actual.getProwizja(), 1e-2);
		assertEquals(expected.getKwotaKredytowania(), actual.getKwotaKredytowania(), 1e-2);
		assertEquals(expected.getKwotaDoWyplaty(), actual.getKwotaDoWyplaty(), 1e-2);
		assertEquals(expected.getSumaSplat(), actual.getSumaSplat(), 1e-2);
	}
}
