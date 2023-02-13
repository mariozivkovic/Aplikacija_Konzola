package zivkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import zivkovic.Pomocno;
import zivkovic.Start;
import zivkovic.model.Busotina;
import zivkovic.model.NaftnoPolje;

public class ObradaBusotina {
	

	private List<Busotina> busotine;
	private Start start;
	
	

	public ObradaBusotina(Start start) {
		super();
		this.start = start;
		busotine = new ArrayList<>();
		testPodaci();
	}
	
	

	public ObradaBusotina(List<Busotina> busotine, Start start) {
		super();
		this.busotine = busotine;
		this.start = start;
		testPodaci();
	}
	
	private void testPodaci() {
		if(Pomocno.DEV) {
			
			busotine.add(new Busotina(1, "LA-12", true, start.getNaftnaPolja().getNaftnaPolja().subList(0, 1)));
			busotine.add(new Busotina(2, "LA-10", true, start.getNaftnaPolja().getNaftnaPolja().subList(0, 1)));
			busotine.add(new Busotina(3, "LA-17", true, start.getNaftnaPolja().getNaftnaPolja().subList(0, 1)));
			
			
		}
		
	}



	public void izbornik() {
		System.out.println("");
		System.out.println("Bušotina izbornik");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Pregled svih bušotina");
		System.out.println("2. Unos nove bušotine");
		System.out.println("3. Promjena postojeće bušotine");
		System.out.println("4. Brisanje bušotine");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
		
	}



	private void odabirIzbornika() {
		switch(Pomocno.unesiBrojRaspona("Odaberi opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if(busotine.size()==0) {
				System.out.println("Nema bušotine koju bi mijenjali");
				izbornik();
			}else {
			promjena();
			}
			break;
		case 4:
			if(busotine.size()==0) {
				System.out.println("Nema bušotine koju bi brisali");
				izbornik();
			}else {
			brisanje();
			}
			break;
		case 5:
			start.glavniIzbornik();
		}
		
		
	}



	private void brisanje() {
		pregled(false);
		int rb = Pomocno.unesiBrojRaspona("Odaberite bušotinu koju želite obrisati: ", 1, busotine.size());
		busotine.remove(rb-1);
		izbornik();
		
	}



	private void promjena() {
		pregled(false);
		int rb = Pomocno.unesiBrojRaspona("Odaberite bušotinu koju želite promjeniti: ", 1, busotine.size());
		Busotina b = busotine.get(rb-1);
		b.setSifra(Pomocno.unesiBrojRaspona("Unesite šifru bušotine: ", 1, Integer.MAX_VALUE));
		b.setNaziv(Pomocno.unosTeksta("Unesite naziv bušotine: "));
		b.setAktivna(Pomocno.aktivnost("Upišite dali je bušotina aktivna DA/NE: "));
	
		izbornik();
		
	}



	private void unosNovog() {
		Busotina b = new Busotina();
		b.setSifra(Pomocno.unesiBrojRaspona("Unesi šifru bušotine: ", 1, Integer.MAX_VALUE));
		b.setNaziv(Pomocno.unosTeksta("Unesi naziv bušotine: "));
		b.setAktivna(Pomocno.aktivnost("Upišite dali je bušotina aktivna DA/NE: "));
		
		
		while(true) {
			start.getNaftnaPolja().pregled(false);
		int	rb = Pomocno.unesiBrojRaspona("Odaberite naftno poje na kojem se nalazi bušotina: ", 1,
					start.getNaftnaPolja().getNaftnaPolja().size());
		b.getNaftnaPolja().add(start.getNaftnaPolja().getNaftnaPolja().get(rb - 1));
		if(Pomocno.unesiBrojRaspona("0 za kraj dodavanja naftnog polja: ", 0, Integer.MAX_VALUE)==0) {
			break;
		}
		}
		busotine.add(b);
		izbornik();
		
	}



	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Bušotine u aplikaciji");
		int rb=1;
		for(Busotina b : busotine) {
			System.out.println(rb++ + ". " + b);
		}
		if(prikaziIzbornik) {
		izbornik();
		}
	}



	public List<Busotina> getBusotine() {
		return busotine;
	}

	public void setBusotine(List<Busotina> busotine) {
		this.busotine = busotine;
	}
	
	
	
	
	
	

}
