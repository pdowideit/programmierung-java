package h12;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Klasse die Zahlen in die zugehoerigen Woerter umwandelt
 * 
 * @author Paul Dowideit, Tim Bartel, Andreass Graewingholt
 *
 */
public class Zahlwort {
	private static String[] einers = { "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun" };

	private static String[] zehners = { "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechzig", "siebzig",
			"achtzig", "neunzig" };

	private static String hundert = "hundert";
	private static String tausend = "tausend";

	private static String und = "und";

	private static Map<Integer, String> specials = new HashMap<Integer, String>();
	static {
		specials.put(11, "elf");
		specials.put(12, "zwoelf");
		specials.put(16, "sechzehn");
		specials.put(17, "siebzehn");
	}

	/**
	 * Gibt die Zahl als Textrepraesentation zurueck
	 * 
	 * @param zahl Zahlenwert
	 * @return Zahl als Wort
	 */
	public static String getZahlwort(int zahl) {
		if (zahl < 1 || zahl > 9999) {
			throw new ArithmeticException();
		}

		int einer = zahl % 10;
		zahl /= 10;
		int zehner = zahl % 10;
		zahl /= 10;
		int hunderter = zahl % 10;
		zahl /= 10;
		int tausender = zahl % 10;
		zahl /= 10;

		String einerZehnerString = einers[einer] + und + zehners[zehner];
		if (zehner == 1 || zehner == 0) {
			einerZehnerString = einers[einer] + zehners[zehner];
		}

		if (einer == 0) {
			einerZehnerString = zehners[zehner];
		}

		if (specials.containsKey(einer + 10 * zehner)) {
			einerZehnerString = specials.get(einer + 10 * zehner);
		}

		if (zehner == 0 && einer == 1) {
			einerZehnerString = "eins";
		}

		String hunderterString = einers[hunderter] + hundert;
		if (hunderter == 0) {
			hunderterString = "";
		}

		String tausenderString = einers[tausender] + tausend;
		if (tausender == 0) {
			tausenderString = "";
		}

		return tausenderString + hunderterString + einerZehnerString;
	}

	/**
	 * Gibt einen Stream an Woertern zurueck die die Zahlen im uebergebenen Bereich
	 * beschreiben
	 * 
	 * @param start Anfang Bereich (inkl.)
	 * @param stop  Ende Bereich (inkl.)
	 * @return Stream mit Woertern zu den Zahlen im Bereich
	 */
	public static Stream<String> getZahlStream(int start, int stop) {
		return IntStream.rangeClosed(start, stop).mapToObj(Zahlwort::getZahlwort);
	}
}
