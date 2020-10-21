package h09;

/**
 * Fehler der geworfen wird wenn versucht wird eine nicht bewegbare Platte zu
 * verschieben
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class WrongMoveException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongMoveException(int i) {
		super("No move possible for plate " + i);
	}
}
