package h10;

/**
 * Exception die geworfen wird, sofern eine Bewegung fuer eine Figur nicht
 * moeglich ist
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class WrongMoveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WrongMoveException(String msg) {
		super(msg);
	}

	public WrongMoveException(Position pos) {
		this("No move possible to " + pos.toString());
	}
}
