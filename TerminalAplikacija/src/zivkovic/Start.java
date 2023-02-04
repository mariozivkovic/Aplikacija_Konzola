package zivkovic;

import java.util.Scanner;

import zivkovic.obrada.ObradaBusotina;
import zivkovic.obrada.ObradaNaftnoPolje;
import zivkovic.obrada.ObradaOdrzavanje;
import zivkovic.obrada.ObradaPosao;
import zivkovic.obrada.ObradaZaposlenik;

public class Start {
	
	private ObradaNaftnoPolje naftnaPolja;
	private ObradaBusotina busotine;
	private ObradaZaposlenik zaposlenici;
	private ObradaPosao poslovi;
	private ObradaOdrzavanje odrzavanja;
	
	
	public Start() {
		Pomocno.ulaz = new Scanner(System.in);
		naftnaPolja = new ObradaNaftnoPolje(this);
		zaposlenici = new ObradaZaposlenik(this);
		busotine = new ObradaBusotina(this);
		poslovi = new ObradaPosao(this);
		odrzavanja = new ObradaOdrzavanje(this);
		pozdravnaPoruka();
		glavniIzbornik();
	}
	
	
	public void glavniIzbornik() {
		System.out.println("");
		System.out.println("GLAVNI IZBORNIK");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Naftna polja");
		System.out.println("2. Bušotine");
		System.out.println("3. Zaposlenici");
		System.out.println("4. Poslovi");
		System.out.println("5. Održavanja");
		System.out.println("6. Izlaz iz programa");
		odabirGlavnogIzbornika();
		
	}


	private void odabirGlavnogIzbornika() {
		switch(Pomocno.unesiBrojRaspona("Odabrana opcija: ", 1, 6)) {
			
		case 1:
			naftnaPolja.izbornik();
			break;
		case 2:
			busotine.izbornik();
			break;
		case 3:
			zaposlenici.izbornik();
			break;
		
		case 6:
			System.out.println("Doviđenja");
		}
		
	}

	


	


	private void pozdravnaPoruka() {
		System.out.println("Dobrodošli u terminal aplikaciju Otpremna stanica");
		
	}
	


	public ObradaNaftnoPolje getNaftnaPolja() {
		return naftnaPolja;
	}



	public static void main(String[] args) {
		if(args.length==1) {
			Pomocno.DEV=true;
		}else {
			Pomocno.DEV=false;
		}
		
		new Start();
	}
	
	
	

}
