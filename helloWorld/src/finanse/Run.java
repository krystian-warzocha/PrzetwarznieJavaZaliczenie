package finanse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import finanse.domain.Pies;
import finanse.domain.Samochod;
import finanse.domain.RodzajPaliwa;
import finanse.domain.RodzajSilnika;
import finanse.kolekcje.DzienTygodnia;
import finanse.kolekcje.Kalkulator;
import finanse.kolekcje.KalkulatorImpl;

public class Run {

	public static void main(String[] args) {
		
		Map<String, List<Samochod>> baza = new HashMap<String, List<Samochod>>();
		List<Samochod> autaNiemieckie = new ArrayList<>();
		List<Samochod> autaFrancuskie = new ArrayList<>();
		
		autaNiemieckie.add(new Samochod("Audi", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY));
		autaNiemieckie.add(new Samochod("BMW", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY));
		
		autaFrancuskie.add(new Samochod("Renault", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY));
		autaFrancuskie.add(new Samochod("Peugeot", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY));
		autaFrancuskie.add(new Samochod("Citroen", RodzajPaliwa.BENZYNA, RodzajSilnika.BENZYNOWY));
		
		baza.put("Niemcy", autaNiemieckie);
		baza.put("Francja", autaFrancuskie);
		
		for(String kraj : baza.keySet()) {
			System.out.println("Kraj: " + kraj + ":");
			for(Samochod s : baza.get(kraj)) {
				System.out.println("Samochod: " + s.getMarka());
			}
			System.out.println("------------------");
		}
		
//		Kalkulator k = new KalkulatorImpl();
//		System.out.println(k.dodaj(1, 2));
//		System.out.println(k.dziel(1, 0));
//		
//		DzienTygodnia dzien1 = DzienTygodnia.WTO;
//		System.out.println(dzien1);
//		
//		List<Pies> psy = new ArrayList<Pies>();
//		Pies reksio = new Pies("Reksio");
//		Pies burek = new Pies("Burek");
//		psy.add(reksio);
//		psy.add(burek);
//		psy.add(new Pies("Ĺ�ajka"));
//		for(Pies pies : psy) {
//			System.out.println(pies.getImie());
//		}
//		System.out.println(psy.get(1).getImie());
		
		
	}

}
