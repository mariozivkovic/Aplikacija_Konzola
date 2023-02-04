package zivkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import zivkovic.Pomocno;
import zivkovic.Start;
import zivkovic.model.NaftnoPolje;

public class ObradaNaftnoPolje {
	
	private List<NaftnoPolje> naftnaPolja;
	private Start start;
	
	

	public ObradaNaftnoPolje(Start start) {
		super();
		this.start=start;
		naftnaPolja = new ArrayList<>();
		testPodaci();
	}

	public ObradaNaftnoPolje(Start start, List<NaftnoPolje> naftnaPolja) {
		super();
		this.naftnaPolja = naftnaPolja;
		testPodaci();
	}
	private void testPodaci() {
		if(Pomocno.DEV) {
			naftnaPolja.add(new NaftnoPolje(1, "Ladislavci"));
			naftnaPolja.add(new NaftnoPolje(2, "Crnac"));
			naftnaPolja.add(new NaftnoPolje(3, "Kućanci"));
		}
		
	}
	public void izbornik() {
		System.out.println("");
		System.out.println("Naftno polje izbornik");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Pregled svih naftnih polja");
		System.out.println("2. Unos novog naftnog polja");
		System.out.println("3. Promjena postojećeg naftnog polja");
		System.out.println("4. Brisanje naftnog polja");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
		
	}
	private void odabirIzbornika() {
		switch(Pomocno.unesiBrojRaspona("Odaberite opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if(naftnaPolja.size()==0) {
				System.out.println("Nema naftnih polja koje bi mjenjali ");
				izbornik();
			}else {
			promjena();
			}
			break;
		case 4:
			if(naftnaPolja.size()==0) {
				System.out.println("Nema naftnih polja koje bi brisali ");
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
		int rb =Pomocno.unesiBrojRaspona("Odaberite naftno polje koje želite obrisati: ", 1, naftnaPolja.size());
		naftnaPolja.remove(rb - 1);
		izbornik();
		
		
	}

	private void promjena() {
		pregled(false);
		int rb =Pomocno.unesiBrojRaspona("Odaberite naftno polje koje želite promjeniti: ", 1, naftnaPolja.size());
		NaftnoPolje nf = naftnaPolja.get(rb - 1);
		nf.setSifra(Pomocno.unesiBrojRaspona("Unesite šifru naftnog polja: ", 1, Integer.MAX_VALUE));
		nf.setNaziv(Pomocno.unosTeksta("Unesite naziv naftnog polja: "));
		izbornik();
		
	}

	private void pregled(boolean prikaziIzbornik) {
		System.out.println("\nNaftna polja u aplikaciji: ");
		int rb=1;
		for(NaftnoPolje nf : naftnaPolja) {
			
			System.out.println(rb++ + ". " + nf);
		}
		if(prikaziIzbornik) {
			izbornik();
		}
		
		
	}

	private void unosNovog() {
		
		naftnaPolja.add(unesiNovoNaftnoPolje());
		izbornik();
		
	}

	private NaftnoPolje unesiNovoNaftnoPolje() {
		NaftnoPolje nf = new NaftnoPolje();
		nf.setSifra(Pomocno.unesiBrojRaspona("Unesite šifru naftnog polja: ", 1, Integer.MAX_VALUE));
		nf.setNaziv(Pomocno.unosTeksta("Unesite naziv naftnog polja: "));
	
		return nf;
	}

	public List<NaftnoPolje> getNaftnaPolja() {
		return naftnaPolja;
	}

	public void setNaftnaPolja(List<NaftnoPolje> naftnaPolja) {
		this.naftnaPolja = naftnaPolja;
	}
	
	
	

}
