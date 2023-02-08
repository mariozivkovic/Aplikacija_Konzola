package zivkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import zivkovic.Pomocno;
import zivkovic.Start;
import zivkovic.model.Zaposlenik;

public class ObradaZaposlenik {

	private List<Zaposlenik> zaposlenici;
	private Start start;

	public ObradaZaposlenik(Start start) {
		super();
		this.start = start;
		zaposlenici = new ArrayList<>();
		testPodaci();
	}

	public ObradaZaposlenik(Start start, List<Zaposlenik> zaposlenici) {
		super();
		this.start = start;
		this.zaposlenici = zaposlenici;
		testPodaci();
	}

	private void testPodaci() {
		if (Pomocno.DEV) {
			zaposlenici.add(
					new Zaposlenik(1, "Josip", "Žagar", "34565456765", "jzagar@gmail.com", "Viši mobilni operater 2"));
			zaposlenici.add(
					new Zaposlenik(2, "Ante", "Tomić", "87654323456", "atomic@gmail.com", "Viši mobilni operater 1"));
			zaposlenici.add(new Zaposlenik(3, "Zoran", "Krivošija", "19876354627", "zkrivi@gmail.com",
					"Viši mobilni operater 1"));
		}

	}

	public void izbornik() {
		System.out.println("");
		System.out.println("Zaposlenik izbornik");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Pregled svih zaposlenika");
		System.out.println("2. Unos novog zaposlenika");
		System.out.println("3. Promjena postojećeg zaposlenika");
		System.out.println("4. Brisanje zaposlenika");
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
			if (zaposlenici.size() == 0) {
				System.out.println("Nema zaposlenika koje bi mijenjali ");
				izbornik();
			} else {
				promjena();
			}
			break;
		case 4:
			if (zaposlenici.size() == 0) {
				System.out.println("Nema zaposlenika koje bi obrisali ");
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
		int rb = Pomocno.unesiBrojRaspona("Odaberite zaposlenika kojeg želite obrisati: ", 1, zaposlenici.size());
		zaposlenici.remove(rb - 1);
		izbornik();
	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unesiBrojRaspona("Odaberite zaposlenika kojeg želite promjeniti: ", 1, zaposlenici.size());
		Zaposlenik z = zaposlenici.get(rb-1);
		z.setSifra(Pomocno.unesiBrojRaspona("Unesite šifru zaposlenika: ", 1, Integer.MAX_VALUE));
		z.setIme(Pomocno.unosTeksta("Unesite ime zaposlenika: "));
		z.setPrezime(Pomocno.unosTeksta("Unesite prezime zaposlenika: "));
		z.setOib(Pomocno.unosTeksta("Unesite oib zaposlenika: "));
		z.setEmail(Pomocno.unosTeksta("Unesite email zaposlenika: "));
		z.setRadnoMjesto(Pomocno.unosTeksta("Unesite radno mjesto zaposlenika: "));
		izbornik();

	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("\n Zaposlenici u aplikaciji: ");
		int rb = 1;
		for (Zaposlenik z : zaposlenici) {
			System.out.println(rb++ + ". " + z);
		}
		if (prikaziIzbornik) {
			izbornik();
		}
	}

	private void unosNovog() {
		zaposlenici.add(unosNovogZaposlenika());
		izbornik();

	}

	private Zaposlenik unosNovogZaposlenika() {
		Zaposlenik z = new Zaposlenik();
		z.setSifra(Pomocno.unesiBrojRaspona("Unesite šifru zaposlenika: ", 1, Integer.MAX_VALUE));
		z.setIme(Pomocno.unosTeksta("Unesite ime zaposlenika: "));
		z.setPrezime(Pomocno.unosTeksta("Unesite prezime zaposlenika: "));
		z.setOib(Pomocno.unesiOIB("Unesite oib zaposlenika: "));
		z.setEmail(Pomocno.unosTeksta("Unesite email zaposlenika: "));
		z.setRadnoMjesto(Pomocno.unosTeksta("Unesite radno mjesto zaposlenika: "));
		return z;
	}

	public List<Zaposlenik> getZaposlenici() {
		return zaposlenici;
	}

	public void setZaposlenici(List<Zaposlenik> zaposlenici) {
		this.zaposlenici = zaposlenici;
	}

}
