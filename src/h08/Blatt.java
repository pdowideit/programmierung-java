package h08;

/**
 * Repraesentiert ein Heads-Up Poker Blatt mit genau 3 Karten
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Blatt {
	/**
	 * Finales Feld mit 3 Ganzzahlen
	 */
	private final int[] karten = new int[3];

	/**
	 * Initialisiert das Blatt mit genau 3 Karten zwischen 2 (inkl.) und 14 (inkl.)
	 * 
	 * Wirft eine Exception, wenn entweder eine falsche Anzahl Karten gegeben wird,
	 * oder die Kartenwerte nicht im Intervall liegen
	 * 
	 * @param karten Feld mit den Werten der Karten mit Bedingungen: Laenge=3,
	 *               2<=Kartenwert<=14
	 */
	public Blatt(int[] karten) {
		if (karten.length != 3) {
			throw new IncorrectCardCountException(karten.length);
		}
		int i = 0;
		for (int karte : karten) {
			if (!isCorrectCardValue(karte)) {
				throw new IncorrectCardValueException(karte);
			} else {
				this.karten[i] = karte;
			}
			i++;
		}

	}

	/**
	 * Ueberprueft ob ein Kartenwert im Intervall [2;14] liegt
	 * 
	 * @param karte Kartenwert
	 * @return 2<=Kartenwert<=14
	 */
	private boolean isCorrectCardValue(int karte) {
		return (karte >= 2 && karte <= 14);
	}

	/**
	 * Gibt Karten zurueck
	 * 
	 * @return Feld mit Kartenwerten
	 */
	public int[] getKarten() {
		return karten;
	}

	@Override
	public String toString() {
		return karten[0] + ", " + karten[1] + ", " + karten[2];
	}

}
