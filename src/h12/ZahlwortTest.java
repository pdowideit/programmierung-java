package h12;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Klasse die die Zahlwort Klasse mithilfe von JUnit Funktionen testet.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreass Graewingholt
 *
 */
public class ZahlwortTest {
	@Test
	public void test1() {
		int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69, 70, 131, 195, 2345 };
		String[] ergebnisse = { "eins", "zehn", "elf", "zwoelf", "sechzehn", "siebzehn", "zwanzig", "achtunddreissig",
				"neunundsechzig", "siebzig", "einhunderteinunddreissig", "einhundertfuenfundneunzig",
				"zweitausenddreihundertfuenfundvierzig" };
		for (int i = 0; i < testtabelle.length; i++) {
			assert Zahlwort.getZahlwort(testtabelle[i]).equals(ergebnisse[i]);
		}
	}

	@Test
	public void test2() {
		try {
			Zahlwort.getZahlwort(0);
		} catch (ArithmeticException e) {
			return;
		}
		fail();
	}

	@Test
	public void test3() {
		try {
			Zahlwort.getZahlwort(10000);
		} catch (ArithmeticException e) {
			return;
		}
		fail();
	}

	@Test
	public void test4() {
		Object[] res = { "acht", "neun", "zehn", "elf", "zwoelf" };
		Object[] erg = Zahlwort.getZahlStream(8, 12).map(i -> i.toString()).toArray();

		assertArrayEquals(res, erg);
	}
}
