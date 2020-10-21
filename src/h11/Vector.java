package h11;

/**
 * Hilfsklasse zur Repraesentation eines Vektors in einem 2D Koordinatensystem
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Vector {
	/**
	 * X,Y Koordinate
	 */
	double x, y;

	/**
	 * Initialisiert neuen Vektor
	 * 
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 */
	public Vector(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Streckt bzw. staucht den Vektor
	 * 
	 * @param factor Faktor mit dem multipliziert wird
	 */
	public void mult(double factor) {
		this.x *= factor;
		this.y *= factor;
	}

	/**
	 * Gibt die Laenge des Vektors zurueck
	 * 
	 * @return Laenge
	 */
	public double len() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/**
	 * Addiert Vektor auf das aktuelle Objekt
	 * 
	 * @param v Zu addierender Vektor
	 */
	public void add(Vector v) {
		this.x += v.x;
		this.y += v.y;
	}

	/**
	 * Addiert 2 Vektoren ohne sie zu veraendern und gibt die Summe als Vektor
	 * zurueck
	 * 
	 * @param v1 Vektor 1
	 * @param v2 Vektor 2
	 * @return Vektor 1 + 2
	 */
	public static Vector add(Vector v1, Vector v2) {
		return new Vector(v1.x + v2.x, v1.y + v2.y);
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
