package h11;

/**
 * Klasse zur Generierung der Koordinaten der Punkte in einem Kochfraktal mit
 * einstellbarer Rekursionstiefe.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class KochKurve {
	/**
	 * Der letzte Vektor, der zur Ausgabe gespeichert wird
	 */
	private static Vector last;

	/**
	 * Hauptmethode zum berechnen der Kochkurve
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		int rek = 5;
		kochKurve(0, 0, 1000, 0, rek);
		KochCanvas.points.add(last);
		System.out.println(last);
		kochKurve(1000, 0, 500, 900, rek);
		KochCanvas.points.add(last);
		System.out.println(last);
		kochKurve(500, 900, 0, 0, rek);
		KochCanvas.points.add(last);
		System.out.println(last);
		KochCanvas.run();
	}

	/**
	 * Rekursive Methode, die Koordinaten einer Kochkurve berechnet und sowohl
	 * ausgibt, als auch zur Visualisierung an die Canvas Klasse uebergibt
	 * 
	 * @param ax  X-Koordinate Punkt A
	 * @param ay  Y-Koordinate Punkt A
	 * @param bx  X-Koordinate Punkt B
	 * @param by  Y-Koordinate Punkt B
	 * @param rek Aktuelle Rekursionstiefe
	 */
	public static void kochKurve(double ax, double ay, double bx, double by, int rek) {
		// speichere koordinaten in objekten
		Vector a = new Vector(ax, ay);
		Vector b = new Vector(bx, by);

		// pruefe abbruchbedingung der rekursion
		if (rek == 0) {
			// speichere & schreibe koordinate
			KochCanvas.points.add(a);
			System.out.println(a);
			return;
		}

		// speichere letzten punkt zur spaeteren ausgabe
		last = b;

		// berechne x und y differenz der beiden vektoren
		Vector diff = new Vector(bx - ax, by - ay);

		// berechne laenge der strecke und die daraus resultierende hoehe
		double len = Math.sqrt(Math.pow(diff.x, 2) + Math.pow(diff.y, 2));
		double height = Math.sqrt(Math.pow(len / 3, 2) - Math.pow(len / 6, 2));

		// berechne teilstuecke
		Vector c = new Vector(ax + (diff.x / 3), ay + (diff.y / 3));
		Vector d = new Vector(ax + 2 * (diff.x / 3), ay + 2 * (diff.y / 3));

		// berechne mitte
		Vector center = new Vector(ax + (diff.x / 2), ay + (diff.y / 2));

		// berechne und strecke orthogonalen vektor
		Vector orth = new Vector(-diff.y, diff.x);
		orth.mult(height / len);

		// addiere orthogonalen vektor mit angepasster laenge zu mitte
		Vector e = Vector.add(center, orth);

		// rekursionsschritte
		// a -> c
		kochKurve(a, c, rek - 1);
		// c->e
		kochKurve(c, e, rek - 1);
		// e ->d
		kochKurve(e, d, rek - 1);
		// d->b
		kochKurve(d, b, rek - 1);
	}

	/**
	 * Hilfsmethode die die andere kochKurve Methode mit den Koordinaten der
	 * uebergebenen Vektoren aufruft
	 * 
	 * @param a   Vektor A
	 * @param b   Vektor B
	 * @param rek Rekursionstiefe
	 */
	private static void kochKurve(Vector a, Vector b, int rek) {
		kochKurve(a.x, a.y, b.x, b.y, rek);
	}
}
