package h10;

/**
 * Exception die geworfen wird, sofern eine nicht existente Position erstellt
 * wird.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class WrongPositionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongPositionException(Position pos) {
		super(pos.toString() + " is no valid position!");
	}
}
