package h09;

/**
 * Testet das Schiebepuzzle mit denen in der Aufgabenstellung gegebenen
 * Methodenaufrufen
 * 
 * @author Paul Dowideit, Tim Bartel, Andres Graewingholt
 *
 */
public class SchiebepuzzleTest {
	public static void main(String[] args) {
		Schiebepuzzle puzzle = new Schiebepuzzle();
		// Mischen nicht vergessen, ansonsten hat der Spieler sehr schnell gewonnen
		System.out.println(puzzle);
		puzzle.mische();
		System.out.println(puzzle);
		// Testen des Loesungsalgorithmus
		// -> zufaellig schieben
		Loesungsalgorithmus alg1 = new RandomAlg();
		alg1.loese(puzzle);
	}
}
