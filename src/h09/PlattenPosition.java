package h09;

/**
 * Repraesentiert die Position einer Platte auf dem Spielplan
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class PlattenPosition {
	/**
	 * Koordinate der Platte im Spielfeld
	 */
	int x, y; // 0 < x,y < 5

	/**
	 * Initialisiert Platte mit den uebergebenen Werten. Gibt Fehler aus wenn eine
	 * der Koordinaten im Spielfeld nicht existiert
	 * 
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 */
	public PlattenPosition(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "PlattenPosition [x=" + x + ", y=" + y + "]";
	}

}
