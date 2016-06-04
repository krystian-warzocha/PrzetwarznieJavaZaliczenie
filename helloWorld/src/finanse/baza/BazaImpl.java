package finanse.baza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import finanse.domain.RodzajPaliwa;
import finanse.domain.RodzajSilnika;
import finanse.domain.Samochod;

public class BazaImpl implements BazaSamochodow {
	
	private Map<Wojewodztwo, List<Samochod>> baza = new HashMap<>();
	
	public BazaImpl() {
		for(Wojewodztwo w : Wojewodztwo.values()) {
			baza.put(w, new ArrayList<Samochod>());
		}
	}

	@Override
	public void add(Samochod s, Wojewodztwo w) {
		baza.get(w).add(s);
	}

	@Override
	public List<Samochod> szukaj(Wojewodztwo w) {
		return baza.get(w);
	}

	@Override
	public List<Samochod> szukaj(String marka) {
		List<Samochod> l = new ArrayList<>();
		for(Wojewodztwo w : baza.keySet()) {
			for(Samochod s : baza.get(w)) {
				if(marka.equals(s.getMarka()) && !l.contains(s)) {
					l.add(s);
				}
			}
		}
		return l;
	}
	
	@Override
	public List<Samochod> szukaj(RodzajPaliwa rodzajPaliwa) {
		List<Samochod> l = new ArrayList<>();
		for(Wojewodztwo w : baza.keySet()) {
			for(Samochod s : baza.get(w)) {
				if(rodzajPaliwa.equals(s.getRodzajPaliwa()) && !l.contains(s)) {
					l.add(s);
				}
			}
		}
		return l;
	}
	
	@Override
	public List<Samochod> szukaj(RodzajSilnika rodzajSilnika) {
		List<Samochod> l = new ArrayList<>();
		for(Wojewodztwo w : baza.keySet()) {
			for(Samochod s : baza.get(w)) {
				if(rodzajSilnika.equals(s.getRodzajSilnika()) && !l.contains(s)) {
					l.add(s);
				}
			}
		}
		return l;
	}

}
