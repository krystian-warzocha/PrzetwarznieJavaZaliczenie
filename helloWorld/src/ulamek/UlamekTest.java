package ulamek;

import static org.junit.Assert.*;

import org.junit.Test;

public class UlamekTest {
	
	@Test
	public void rownosc() {
		Ulamek u1 = new Ulamek(10000001, 20000000);
		Ulamek u2 = new Ulamek(2, 4);
		
		assertEquals(u1, u2);
	}
	
	@Test
	public void mnozenie() {
		Ulamek u1 = new Ulamek(4, 8);
		Ulamek u2 = new Ulamek(2, 4);
		
		assertEquals(new Ulamek(1, 4), u1.mnoz(u2));
	}
	
	@Test
	public void dzielenie() {
		Ulamek u1 = new Ulamek(4, 8);
		Ulamek u2 = new Ulamek(2, 4);
		
		assertEquals(new Ulamek(1, 1), Ulamek.dziel(u1, u2));
	}

	@Test
	public void dodaj() {
		Ulamek u1 = new Ulamek(4, 8);
		Ulamek u2 = new Ulamek(2, 4);
		
		assertEquals(new Ulamek(1, 1), Ulamek.dodaj(u1, u2));
	}

	@Test
	public void odejmij() {
		Ulamek u1 = new Ulamek(6, 8);
		Ulamek u2 = new Ulamek(2, 4);
		
		assertEquals(new Ulamek(1, 4), u1.odejmij(u2));
	}

}
