package h06;

import java.util.ArrayList;
import java.util.List;

/**
 * Repraesentiert eine Liste an Rechenoperationen die sukzessiv auf ein Feld an
 * Zahl angewandt werden kann
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Rechenoperationsliste {
	private List<Rechenoperation> operationen;

	/**
	 * Initialisiert die Liste der Rechenoperationen
	 */
	public Rechenoperationsliste() {
		operationen = new ArrayList<Rechenoperation>();
	}

	/**
	 * Fuegt der Liste eine Rechenoperation hinzu
	 * 
	 * @param operation Hinzuzufuegende Rechenoperation
	 */
	public void add(Rechenoperation operation) {
		this.operationen.add(operation);
	}

	/**
	 * Transformiert ein double Feld indem die Rechenoperationen nacheinander
	 * angewandt werden
	 * 
	 * @param feld Zu transformierendes Feld (wird nicht veraendert)
	 * @return Transformiertes Feld
	 */
	public double[] transform(double[] feld) {
		double[] res = feld.clone();
		for (Rechenoperation operation : operationen) {
			for (int i = 0; i < res.length; i++) {
				res[i] = operation.berechne(res[i]);
			}
		}
		return res;
	}
}
