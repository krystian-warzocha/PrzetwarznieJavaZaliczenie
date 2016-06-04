package ulamek;

public class Ulamek {
	
	private int licznik;
	private int mianownik;
	
	public static Ulamek mnoz(Ulamek u1, Ulamek u2) {
		return u1.mnoz(u2);
	}
	
	public static Ulamek dodaj(Ulamek u1, Ulamek u2) {
		return u1.dodaj(u2);
	}
	
	public static Ulamek odejmij(Ulamek u1, Ulamek u2) {
		return u1.odejmij(u2);
	}
	
	public static Ulamek dziel(Ulamek u1, Ulamek u2) {
		return u1.dziel(u2);
	}
	
	public Ulamek(int licznik, int mianownik) {
		super();
		this.licznik = licznik;
		this.mianownik = mianownik;
	}
	
	public Ulamek mnoz(Ulamek u) {
		int resultLicznik = this.licznik*u.licznik;
		int resultMianownik = this.mianownik*u.mianownik;
		Ulamek result = new Ulamek(resultLicznik, resultMianownik);
		return result.skroc();
	}
	
	public Ulamek dodaj(Ulamek u) {
		int resultLicznik = this.licznik * u.mianownik + u.licznik * this.mianownik;
		int resultMianownik = this.mianownik * u.mianownik;
		Ulamek result = new Ulamek(resultLicznik, resultMianownik);
		return result.skroc();
	}
	
	public Ulamek odejmij(Ulamek u) {
		Ulamek m = new Ulamek(-u.licznik, u.mianownik);
		return this.dodaj(m);
	}
	
	public Ulamek dziel(Ulamek u) {
		Ulamek o = new Ulamek(u.mianownik, u.licznik);
		return mnoz(o);
	}
	
	public Ulamek skroc() {
		int nwd = NWD(Math.abs(licznik), Math.abs(mianownik));
		this.licznik /= nwd;
		this.mianownik /= nwd;
		return this;
	}
	
	private static int NWD(int a, int b) {
		if(b == 0) return a;
		return NWD(b, (a % b));
	}
	
//	@Override
//	public boolean equals(Object o) {
//		if(!(o instanceof Ulamek))
//			return false;
//		
//		Ulamek u = (Ulamek)o;
//		u.skroc();
//		this.skroc();
//		
//		if(u.licznik == this.licznik && u.mianownik == this.mianownik)
//			return true;
//		
//		return false;
//	}

	@Override
	public String toString() {
		return "[" + licznik + "/" + mianownik + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + licznik;
		result = prime * result + mianownik;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ulamek other = (Ulamek) obj;
		
		double val1 = 1.0*licznik/mianownik;
		double val2 = 1.0*other.licznik/other.mianownik;
		
//		if(Double.compare(val1, val2) != 0)
//			return false;
//		
		if(Math.abs(val1 - val2) > 1e-5)
			return false;
		
		return true;
	}
	
}
