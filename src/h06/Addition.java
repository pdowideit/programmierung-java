package h06;

/**
 * Repraesentiert die Rechenoperation Addition mit einem festen Zahlenwert
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Addition implements Rechenoperation {
	private double x;

	/**
	 * Initialisiert ein Additionsobjekt
	 * 
	 * @param x Fester Zahlenwert zur Addition
	 */
	public Addition(double x) {
		this.x = x;
	}

	@Override
	public double berechne(double x) {
		return this.x + x;
	}

}
