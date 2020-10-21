package h07;

/**
 * Beschreibt die Grundfunktionalitaet einer Gefangenenstrategie
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public interface GefangenenStrategie {
	/**
	 * true := kooperieren; false := betruegen
	 * 
	 * @return
	 */
	boolean getNextDecision();

	/**
	 * Speichert die letzte Entscheidung des Gegenspielers zur Verwendung bei der
	 * eigenen naechsten Entscheidung.
	 * 
	 * Nicht alle Strategien verwenden diesen Wert.
	 * 
	 * @param decision Letzte Entscheidung des Gegners
	 */
	void setOpponentsLastDecision(boolean decision);
}
