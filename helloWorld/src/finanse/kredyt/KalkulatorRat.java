package finanse.kredyt;

public class KalkulatorRat {

	public enum RodzajRatTyp {
		MALEJACE, ROWNE
	}

	public enum ProwizjaTyp {
		NIE_UWZGLEDNIAJ, POMNIEJSZA, POWIEKSZA, ZAPLACONO
	};

	public RezultatRaty oblicz(long kwotaKredytu, ProwizjaTyp prowizja, double wysokoscProwizji, double oprocentowanie,
			int okresWMiesiacach, RodzajRatTyp rodzajRat) {
		
		RezultatRaty rr = new RezultatRaty();
		double prowizjaKwota = 0.0;
		double kwotaKredytowania = 0.0;
		double kwotaDoWyplaty = 0.0;
		double sumaSplat = 0.0;
		switch(prowizja) {
		case NIE_UWZGLEDNIAJ:
			prowizjaKwota = 0.0;
			kwotaDoWyplaty = kwotaKredytu;
			kwotaKredytowania = kwotaKredytu;
			break;
		case POMNIEJSZA:
			prowizjaKwota = wysokoscProwizji * kwotaKredytu * 0.01;
			kwotaDoWyplaty = kwotaKredytu - prowizjaKwota;
			kwotaKredytowania = kwotaKredytu;
			break;
		case POWIEKSZA:
			prowizjaKwota = wysokoscProwizji * kwotaKredytu * 0.01;
			kwotaDoWyplaty = kwotaKredytu;
			kwotaKredytowania = kwotaKredytu + prowizjaKwota;
			break;
		case ZAPLACONO:
			prowizjaKwota = wysokoscProwizji * kwotaKredytu * 0.01;
			kwotaDoWyplaty = kwotaKredytu;
			kwotaKredytowania = kwotaKredytu;
			break;
		}
		
		rr.setKwotaKredytowania(kwotaKredytowania);
		rr.setKwotaDoWyplaty(kwotaDoWyplaty);
		rr.setProwizja(prowizjaKwota);
		
		switch(rodzajRat) {
		case MALEJACE:
			double pierwszaRata = kwotaKredytowania * oprocentowanie * 0.01 / 12.0;
			double ostatniaRata = kwotaKredytowania / okresWMiesiacach * oprocentowanie * 0.01 / 12.0;
			sumaSplat = obliczSumeSplat(okresWMiesiacach, (pierwszaRata + ostatniaRata) / 2.0) + kwotaKredytowania;
			break;
		case ROWNE:
			double platnoscMiesieczna = kwotaKredytowania * oprocentowanie/12.0 * 0.01 / (1.0-1.0/Math.pow(1.0+oprocentowanie/12.0 * 0.01, okresWMiesiacach));
			sumaSplat = obliczSumeSplat(okresWMiesiacach, platnoscMiesieczna);
			break;
		default:
			break;
		}
		
		rr.setSumaSplat(sumaSplat);
		
		return rr;
	}
	
	private double obliczSumeSplat(int okresWMiesiacach, double platnoscMiesieczna) {
		return okresWMiesiacach * platnoscMiesieczna;
	}
}
