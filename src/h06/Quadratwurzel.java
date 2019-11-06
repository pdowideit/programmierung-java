package h06;

/**
 * Repraesentiert die Rechenoperation Quadratwurzel
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Quadratwurzel implements Rechenoperation {

	@Override
	public double berechne(double x) {
		return Math.sqrt(x);
	}

}
