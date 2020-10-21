package h08;

/**
 * Exception die geworfen wird wenn ein Blatt mit der falschen Anzahl an Karten
 * initialisiert wird
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class IncorrectCardCountException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Initilisiert Exception und erstellt Ausgabetext
	 * 
	 * @param count Anzahl an Karten
	 */
	public IncorrectCardCountException(int count) {
		super("Kartenanzahl " + count + " wird nicht akzeptiert!");
	}
}
