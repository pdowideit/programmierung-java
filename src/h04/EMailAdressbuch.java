package h04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Repraesentiert ein E-Mail Adressbuch mit Namen und E-Mail Adresse
 * 
 * @author Paul Dowideit (paul.dowideit@stud.fh-aachen.de, Tim Bartel, Andreas Graewingholt
 *
 */
public class EMailAdressbuch {
	/**
	 * Haelt die Eintraege im Adressbuch
	 */
	Map<String, String> eintraege = new HashMap<String, String>();

	/**
	 * Fuegt einen neuen Eintrag ins Adressbuch hinzu
	 * 
	 * @param name  Name des neuen Eintrags
	 * @param email E-Mail Adresse des neuen Eintrags
	 */
	public void einfuegen(String name, String email) {
		// schreibe eintrag in map
		eintraege.put(name, email);
	}

	/**
	 * Fragt die E-Mail Adresse zum uebergebenen Namen aus dem Adressbuch an Ist die
	 * E-Mail nicht vorhanden wird eine UnknownNameException geworfen
	 * 
	 * @param name Angefragter Name
	 * @return E-Mail Adresse zum angefragten Namen
	 */
	public String abfrage(String name) {
		// hole email adresse aus map, setze default wert wenn nicht vorhanden
		String email = eintraege.getOrDefault(name, null);
		// check ob email adresse gefunden
		if (email == null) {
			// wenn nicht wird exception
			throw new UnknownNameException();
		} else {
			// sonst gib email adresse zurueck
			return email;
		}
	}

	/**
	 * Konvertiert die Eintraege des Adressbuchs in einen String
	 */
	public String toString() {
		// so wie toString in der aufgabenstellung definiert ist reicht hier die
		// toString darstellung von map
		return eintraege.toString();
	}

	/**
	 * Liest ein E-Mail Adressbuch aus einer Textdatei ein Daten werden in einer
	 * Zeile durch ; getrennt
	 * 
	 * @param dateiname Name der zu lesenden Datei
	 * @throws FileNotFoundException wird geworfen wenn die Datei nicht existiert
	 */
	public void einlesen(String dateiname) throws FileNotFoundException {
		// erstelle scanner
		Scanner sc = new Scanner(new File(dateiname), "utf-8");

		// durchlaufe datei
		while (sc.hasNextLine()) {
			// teile daten am ;
			String[] data = sc.nextLine().split(";");
			// fuege daten dem adressbuch hinzu
			this.einfuegen(data[0], data[1]);
		}
		// schlieﬂe scanner
		sc.close();
	}
}
