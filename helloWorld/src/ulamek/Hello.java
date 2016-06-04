package ulamek;

public class Hello {
	public static void main(String[] args) {
		Ulamek u1 = new Ulamek(1, 2);
		Ulamek u2 = new Ulamek(3, 4);
		System.out.println(u1.mnoz(u2));
		System.out.println(u1.dodaj(u2));
		System.out.println(u1.odejmij(u2));
		System.out.println(u1.dziel(u2));
		
		System.out.println();
		System.out.println(Ulamek.mnoz(u1, u2));
	}
}
