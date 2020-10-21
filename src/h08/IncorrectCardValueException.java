package h08;

/**
 * Exception die geworfen wird, wenn ein Blatt mit einem falschen Kartenwert
 * initialisiert wird.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class IncorrectCardValueException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Initialisiert Exception und erstellt Ausgabetext
	 * 
	 * @param val Falscher Kartenwert
	 */
	public IncorrectCardValueException(int val) {
		super(val + " ist kein korrekter Kartenwert!");
	}
}
