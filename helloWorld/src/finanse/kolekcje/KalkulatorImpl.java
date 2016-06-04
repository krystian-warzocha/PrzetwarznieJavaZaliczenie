package finanse.kolekcje;

public class KalkulatorImpl implements Kalkulator {

	@Override
	public int dodaj(int l1, int l2) {
		return l1 + l2;
	}

	@Override
	public int odejmij(int l1, int l2) {
		return l1 - l2;
	}

	@Override
	public double mnoz(double l1, double l2) {
		return l1 * l2;
	}

	@Override
	public double dziel(double l1, double l2) {
//		if(l2 == 0.0) {
//			throw new IllegalArgumentException("Nie mozna dzielic przez zero.");
//		}
		return l1 / l2;
	}

}
