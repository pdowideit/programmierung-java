package h10;

/**
 * Repraesentiert die Position einer Figur auf einem Schachfeld
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Position {
	/**
	 * Koordinate
	 */
	private int x, y;

	/**
	 * Initialisiert eine Position mit den gegebenen Koordinaten
	 * 
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Gibt X-Koordinate zurueck
	 * 
	 * @return X-Koordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gibt Y-Koordinate zurueck
	 * 
	 * @return Y-Koordinate
	 */
	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/**
	 * Ueberprueft ob die gegebenen Koordinaten auf dem Schachfeld existieren
	 * 
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 * @return Wahrheitswert (1<=x<=8 && 1<=y<=8)
	 */
	public static boolean isValid(int x, int y) {
		return ((x >= 1) && (x <= 8) && (y >= 1) && (y <= 8));
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
