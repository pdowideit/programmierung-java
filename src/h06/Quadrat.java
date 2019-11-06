package h06;

/**
 * Repraesentiert die Rechenoperation Quadrierung
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Quadrat implements Rechenoperation {

	@Override
	public double berechne(double x) {
		return Math.pow(x, 2);
	}

}
