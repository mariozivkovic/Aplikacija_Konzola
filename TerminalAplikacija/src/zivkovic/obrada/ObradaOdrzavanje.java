package zivkovic.obrada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zivkovic.Pomocno;
import zivkovic.Start;
import zivkovic.model.Busotina;
import zivkovic.model.NaftnoPolje;
import zivkovic.model.Odrzavanje;
import zivkovic.model.Posao;
import zivkovic.model.PosaoBusotina;
import zivkovic.model.Zaposlenik;

public class ObradaOdrzavanje {

	private List<Odrzavanje> odrzavanja;
	private Start start;

	
	public ObradaOdrzavanje(Start start) {
		super();
		this.start = start;
		odrzavanja = new ArrayList<>();
		testPodaci();
	}
	

	public ObradaOdrzavanje(Start start,List<Odrzavanje> odrzavanja) {
		super();
		this.odrzavanja = odrzavanja;
		this.start = start;
		testPodaci();
	}
	
	private void testPodaci() {
		if(Pomocno.DEV) {
			
		}
		
	}


	public void izbornik() {
		System.out.println("");
		System.out.println("Odrzavanje izbornik");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Pregled svih odrzavanja");
		System.out.println("2. Unos novog odrzavanja");
		System.out.println("3. Promjena postojećeg odrzavanja");
		System.out.println("4. Brisanje odrzavanja");
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
			if(odrzavanja.size()==0) {
				System.out.println("Nema održavanja koje bi mijenjali");
				izbornik();
			}else {
			promjena();
			}
			break;
		case 4:
			if(odrzavanja.size()==0) {
				System.out.println("Nema održavanja koje bi obrisali");
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
		int rb = Pomocno.unesiBrojRaspona("Unesite održavanje koje želite obrisati: ", 1,odrzavanja.size());
		odrzavanja.remove(rb-1);
		izbornik();
		
	}


	private void promjena() {
		pregled(false);
		int rb = Pomocno.unesiBrojRaspona("Unesite održavanje koje želite promjeniti: ", 1,odrzavanja.size());
		Odrzavanje o = odrzavanja.get(rb-1);
	
		
		
	
			}
		
		
		
		
	


	private void unosNovog() {
		Odrzavanje o = new Odrzavanje();
		o.setSifra(Pomocno.unesiBrojRaspona("Unesi šifru odrzavanja: ", 1, Integer.MAX_VALUE));
		o.setDatum(Pomocno.unosDatuma("Unesite datum odrzavanja"));
		
		while(true) {
			start.getZaposlenici().pregled(false);
			int rb = Pomocno.unesiBrojRaspona("Unesite zaposlenika koji obavlja odrzavanje: ", 1,
					start.getZaposlenici().getZaposlenici().size());
			o.getZaposlenici().add(start.getZaposlenici().getZaposlenici().get(rb-1));
			start.getPoslovi().pregled(false);
		   rb = Pomocno.unesiBrojRaspona("Unesite posao koji se obavlja na odrzavanju: ", 1, 
					start.getPoslovi().getPoslovi().size());
			start.getBusotine().pregled(false);
			rb = Pomocno.unesiBrojRaspona("Unesite bušotinu na kojoj se obavlja odrzavanje: ", 1,
					start.getBusotine().getBusotine().size());
			
			
			
			if(Pomocno.unesiBrojRaspona("0 za kraj dodavanja zaposlenika", 0, Integer.MAX_VALUE)==0) {
				break;
		
			}
		
		}
		odrzavanja.add(o);
		izbornik();
		}
		
	





	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Odrzavanja u aplikaciji");
		int rb = 1;
		for(Odrzavanje o : odrzavanja) {
			System.out.println(rb++ + ". " + o);
		}
		if(prikaziIzbornik) {
			izbornik();
		}
	}

	



	




	public List<Odrzavanje> getOdrzavanja() {
		return odrzavanja;
	}

	public void setOdrzavanja(List<Odrzavanje> odrzavanja) {
		this.odrzavanja = odrzavanja;
	}
	

	
}
