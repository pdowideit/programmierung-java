package h04;

import java.io.FileNotFoundException;
/**
* Testet die Funktionen der EMailAdressbuch Klasse
*/
public class EMailAdressbuchTest {
	public static void main(String[] args) {
		EMailAdressbuch ema = new EMailAdressbuch();
		try {
			ema.einlesen("emailadressbuch.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(ema.toString());
		EMailAdressbuch emaMatse = new EMailAdressbuch();
		try {
			emaMatse.einlesen("mitarbeiter_matse_extern.txt");
			emaMatse.einlesen("mitarbeiter_matse_intern.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(emaMatse);
	}
}
