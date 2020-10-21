package p07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		double min = 0.0;
		double max = 10.0;

		Funktion a = (double x) -> (Math.pow(Math.E, x) - 4);
		Funktion b = (double x) -> (Math.log(Math.abs(x + 1) - Math.sin(2 * x) - 0.5));
		Funktion c = (double x) -> (Math.pow(x, 2) - Math.sin(x) - 1);
		Funktion d = (double x) -> (Math.pow(x, 4) + Math.pow(x, 3) - 5);

		Map<Funktion,String> funktionStrings = new HashMap<Funktion, String>();
		funktionStrings.put(a, "A");
		funktionStrings.put(b, "B");
		funktionStrings.put(c, "C");
		funktionStrings.put(d, "D");
		
		
		List<Funktion> funktionen = new ArrayList<Funktion>(Arrays.asList(a, b, c, d));

		Verfahren bis = new Bisektionsverfahren();
		Verfahren sek = new Sekantenverfahren();

		List<Verfahren> verfahren = new ArrayList<Verfahren>(Arrays.asList(bis, sek));

		for (Funktion f : funktionen) {
			System.out.println("Funktion " + funktionStrings.get(f));
			for (Verfahren v : verfahren) {
				System.out.println(String.format("\tNullstelle: %30.15f (%s)", v.getNullstelle(f, min, max), v.toString()));
			}
		}

	}
}
