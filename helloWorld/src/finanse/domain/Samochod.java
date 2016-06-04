package finanse.domain;

public class Samochod {
	
	private String marka;
	private RodzajPaliwa rodzajPaliwa;
	private RodzajSilnika rodzajSilnika;

	public Samochod(String marka, RodzajPaliwa rodzajPaliwa, RodzajSilnika rodzajSilnika) {
		super();
		this.marka = marka;
		this.rodzajPaliwa = rodzajPaliwa;
		this.rodzajSilnika = rodzajSilnika;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public RodzajPaliwa getRodzajPaliwa() {
		return rodzajPaliwa;
	}

	public void setRodzajPaliwa(RodzajPaliwa rodzajPaliwa) {
		this.rodzajPaliwa = rodzajPaliwa;
	}

	public RodzajSilnika getRodzajSilnika() {
		return rodzajSilnika;
	}

	public void setRodzajSilnika(RodzajSilnika rodzajSilnika) {
		this.rodzajSilnika = rodzajSilnika;
	}

	@Override
	public String toString() {
		return "Samochod [marka=" + marka + ", rodzajPaliwa=" + rodzajPaliwa + ", rodzajSilnika=" + rodzajSilnika + "]";
	}

}
