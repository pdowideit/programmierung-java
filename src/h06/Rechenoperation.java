package h06;

/**
 * Interface welches eine Rechenoperation of eine einzelne Zahl repraesentiert
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public interface Rechenoperation {
	/**
	 * Wendet die Rechenoperation auf den uebergebenen Zahlenwert an und gibt das
	 * Ergebnis zurück
	 * 
	 * @param x Zu verwendende Zahl
	 * @return Berechneter Zahlenwert
	 */
	public double berechne(double x);
}
