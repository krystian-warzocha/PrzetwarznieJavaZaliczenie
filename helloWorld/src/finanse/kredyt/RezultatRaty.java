package finanse.kredyt;

public class RezultatRaty {

	private double prowizja;
	private double kwotaKredytowania;
	private double kwotaDoWyplaty;
	private double sumaSplat;

	public RezultatRaty() {
		super();
	}

	public RezultatRaty(double prowizja, double kwotaKredytowania, double kwotaDoWyplaty, double sumaSplat) {
		super();
		this.prowizja = prowizja;
		this.kwotaKredytowania = kwotaKredytowania;
		this.kwotaDoWyplaty = kwotaDoWyplaty;
		this.sumaSplat = sumaSplat;
	}

	public double getProwizja() {
		return prowizja;
	}

	public void setProwizja(double prowizja) {
		this.prowizja = prowizja;
	}

	public double getKwotaKredytowania() {
		return kwotaKredytowania;
	}

	public void setKwotaKredytowania(double kwotaKredytowania) {
		this.kwotaKredytowania = kwotaKredytowania;
	}

	public double getKwotaDoWyplaty() {
		return kwotaDoWyplaty;
	}

	public void setKwotaDoWyplaty(double kwotaDoWyplaty) {
		this.kwotaDoWyplaty = kwotaDoWyplaty;
	}

	public double getSumaSplat() {
		return sumaSplat;
	}

	public void setSumaSplat(double sumaSplat) {
		this.sumaSplat = sumaSplat;
	}
}
