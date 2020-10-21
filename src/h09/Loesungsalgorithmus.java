package h09;

/**
 * Interface zum loesen eines Schiebepuzzles
 * 
 * @author Paul Dowideit, Tim Bartel, Andres Graewingholt
 */
public interface Loesungsalgorithmus {
	/**
	 * Loest das uebergebene Schiebepuzzle mit dem fuer den Algorithmus definierten
	 * Loesungweg und Abbruchbedingungen
	 * 
	 * @param puzzle Zu loesendes Puzzle
	 */
	public void loese(Schiebepuzzle puzzle);
}
