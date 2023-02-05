package zivkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import zivkovic.Pomocno;
import zivkovic.Start;
import zivkovic.model.Posao;

public class ObradaPosao {

	private List<Posao> poslovi;
	private Start start;

	public ObradaPosao(Start start) {
		super();
		this.start = start;
		poslovi = new ArrayList<>();
		testPodaci();
	}

	public ObradaPosao(Start start,List<Posao> poslovi ) {
		super();
		this.poslovi = poslovi;
		testPodaci();
	}

	private void testPodaci() {
		if (Pomocno.DEV) {
			poslovi.add(new Posao(1, "Povlačenje kugle 3\" na češlju La-3"));
			poslovi.add(new Posao(2, "Kontrola rada bušotina i njihalica"));
			poslovi.add(new Posao(3, "Spuštanje kracera,zamjena dijagrama"));
		}

	}

	public void izbornik() {
		System.out.println("");
		System.out.println("Posao izbornik");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Pregled svih poslova");
		System.out.println("2. Unos novog posla");
		System.out.println("3. Promjena postojećeg posla");
		System.out.println("4. Brisanje posla");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();

	}

	private void odabirIzbornika() {
		switch (Pomocno.unesiBrojRaspona("Odaberite opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (poslovi.size() == 0) {
				System.out.println("Nema poslova koje bi mjenjali");
				izbornik();
			} else {
				promjena();
			}
			break;
		case 4:
			if (poslovi.size() == 0) {
				System.out.println("Nema poslova koje bi obrisali");
				izbornik();
			} else {
				brisanje();
			}
			break;
		case 5:
			start.glavniIzbornik();

		}

	}

	private void brisanje() {
		pregled(false);
		int rb = Pomocno.unesiBrojRaspona("Odaberite posao koji želite obrisati: ", 1, poslovi.size());
		poslovi.remove(rb - 1);
		izbornik();

	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unesiBrojRaspona("Odaberite posao koji želite promjeniti: ", 1, poslovi.size());
		Posao p = poslovi.get(rb - 1);
		p.setSifra(Pomocno.unesiBrojRaspona("Unesite šifru posla: ", 1, Integer.MAX_VALUE));
		p.setNaziv(Pomocno.unosTeksta("Unesite naziv posla: "));
		izbornik();

	}
	private void pregled(boolean prikaziIzbornik) {
		System.out.println("\nPoslovi u aplikaciji: ");
		int rb = 1;
		for (Posao p : poslovi) {
			System.out.println(rb++ + ". " + p);
		}
		if (prikaziIzbornik) {
			izbornik();
		}

	}

	private void unosNovog() {

		poslovi.add(unosNovogPosla());
		izbornik();

	}

	private Posao unosNovogPosla() {
		Posao p = new Posao();
		p.setSifra(Pomocno.unesiBrojRaspona("Unesite šifru posla: ", 1, Integer.MAX_VALUE));
		p.setNaziv(Pomocno.unosTeksta("Unesite naziv posla: "));
		return p;
	}

	

	public List<Posao> getPoslovi() {
		return poslovi;
	}

	public void setPoslovi(List<Posao> poslovi) {
		this.poslovi = poslovi;
	}

}
