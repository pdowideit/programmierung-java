package h03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * enthaelt eine Liste von Tagespreisen
 */
public class GoldPreis {
	private ArrayList<GoldTagespreis> list;

	/**
	 * erhaelt einen Dateinamen und liest Goldpreise aus der angegebenen Datei aus
	 * 
	 * @param dateiname Dateiname mit der Liste der Goldpreise
	 * @throws FileNotFoundException Der Testcode erwartet die Exception, daher wird
	 *                               sie hier nicht behandelt
	 */
	public GoldPreis(String dateiname) throws FileNotFoundException {
		list = new ArrayList<GoldTagespreis>();

		File f = new File(dateiname);
		Scanner sc = new Scanner(f);

		while (sc.hasNext()) {
			String[] thisLine = sc.nextLine().split("\t");
			if (thisLine[1].equals("kein Nachweis")) {
				this.list.add(new GoldTagespreis(thisLine[0], -1));
			} else {
				// Das Dateiformat hat ein Dezimalkomma und Tausenderpunkte,
				// benoetigt wird aber ein Dezimalpunkt ohne Tausenderzeichen
				thisLine[1] = thisLine[1].replaceAll("\\.", "").replace(',', '.');
				// Alternativ: double preis = Double.parseDouble(thisLine[1].replaceAll("\\.",
				// ""),Locale.Germany);
				this.list.add(new GoldTagespreis(thisLine[0], Double.parseDouble(thisLine[1])));
			}
		}
		sc.close();
	}

	/**
	 * Erhaelt einen String mit Tag, Monat und Jahr und gibt den Preis dieses Tages
	 * zurueck
	 * 
	 * @param datum Datum des Tages
	 * @return Preis an diesem Tag
	 */
	public double getPreis(String datum) {
		for (GoldTagespreis g : this.list) {
			if (g.datum.equals(datum)) {
				return g.preis;
			}
		}
		throw new NumberFormatException();
	}

	/**
	 * Gibt alle Tage aus, an denen Gold am billigsten bzw. am teuersten war.
	 */
	public void printMinMax() {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;

		// min und max Preise ermitteln
		for (GoldTagespreis g : this.list) {
			// springe zum naechsten Objekt der Liste wenn kein Tagespreis definiert ist
			if (g.preis == -1) {
				continue;
			}
			// vergleiche Tagespreise und überschreibe ggf. min bzw. max
			if (g.preis > max) {
				max = g.preis;
			} else if (g.preis < min) {
				min = g.preis;
			}
		}

		// Alle Daten mit min Preis ausgeben
		System.out.println("Den niedrigsten Goldpreis von " + min + " gab es an folgenden Tagen:");
		for (GoldTagespreis g : this.list) {
			if (g.preis == min) {
				System.out.println(g.datum);
			}
		}

		// Alle Daten mit max Preis ausgeben
		System.out.println("Den hoechsten Goldpreis von " + max + " gab es an folgenden Tagen:");
		for (GoldTagespreis g : this.list) {
			if (g.preis == max) {
				System.out.println(g.datum);
			}
		}
	}
}
