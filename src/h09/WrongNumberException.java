package h09;

/**
 * Fehler der geworfen wird wenn versucht wird eine Platte zu erzeugen deren
 * Zahlenwert auf dem Spielfeld nicht existiert
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class WrongNumberException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongNumberException(int i) {
		super("Number " + i + " does not exist in game");
	}
}
