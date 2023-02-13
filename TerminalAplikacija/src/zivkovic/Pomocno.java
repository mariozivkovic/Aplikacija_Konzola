package zivkovic;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class Pomocno {

	public static Scanner ulaz;
	public static boolean DEV;

	public static int unesiBrojRaspona(String poruka, int min, int max) {
		int i;
		while (true) {
			try {
				System.out.print(poruka);
				i = Integer.parseInt(ulaz.nextLine());
				if (i < min || i > max) {
					System.out.println("Broj mora biti između " + min + " i " + max);
					continue;
				}
				return i;
			} catch (Exception e) {
				System.out.println("Niste unijeli broj");
			}
		}
	}

	public static String unosTeksta(String poruka) {
		String s;
		while (true) {
			System.out.print(poruka);
			s = ulaz.nextLine();
			if (s.trim().isEmpty()) {
				System.out.println("Obavezan unos");
				continue;
			}
			return s;
		}

	}

	public static boolean aktivnost(String poruka) {

		System.out.println(poruka);
		String s = "";
		while (true) {

			s = unosTeksta("");
			if (s.equalsIgnoreCase("DA")) {
				return true;
			}
			if (s.equalsIgnoreCase("NE")) {
				return false;
			}
			System.out.println("nepoznat upis");

		}

	}

	public static String unesiOIB(String poruka) {
		String oib = "";
		while (true) {
			try {
				System.out.print(poruka);
				oib = ulaz.nextLine();

				if (oib.length() != 11) {
					throw new Exception("OIB mora imati točno 11 znamenki brojeva");
				}

				long oibLong = Long.parseLong(oib);
				break;
			} catch (Exception e) {
				System.out.println("Greška: " + e.getMessage());
			}
		}

		return oib;
	}

	public static Date unosDatuma(String poruka) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		while (date == null) {
			System.out.print(poruka + " (" +"dd-MM-yyyy" + "): ");
			String dateStr = ulaz.nextLine();
			try {
				date = format.parse(dateStr);
			} catch (Exception e) {
				System.out.println("Pogrešan format datuma. Pokušajte ponovno.");
			}
		}

		return date;
	}

	public static BigDecimal unosDecimal(String poruka) {
		System.out.print(poruka);
		String tlakovi = ulaz.nextLine();
		return new BigDecimal(tlakovi);

	}
	}

