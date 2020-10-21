package h09;

/**
 * Algorithmus zur Loesung eines Schiebepuzzles nach dem Zufallsprinzip. Loesung
 * heiﬂt hier das verschieben der Platte 1 auf das erste Feld
 * 
 * @author Paul Dowideit, Tim Bartel, Andres Graewingholt
 *
 */
public class RandomAlg implements Loesungsalgorithmus {
	@Override
	public void loese(Schiebepuzzle puzzle) {
		int steps = loeseRec(puzzle, 0);
		System.out.println("Recursion steps: " + steps);
	}

	/**
	 * Loest das Puzzle rekursiv nach dem Zufallsprinzip
	 * 
	 * @param puzzle Zu loesendes Puzzle
	 * @param steps  aktuelle Anzahl der Rekursionsschritte
	 * @return Anzahl der Rekursionsschritte
	 */
	public int loeseRec(Schiebepuzzle puzzle, int steps) {
		PlattenPosition posPlatte1 = puzzle.getPlattenPosition(1);
		if (posPlatte1.x == 0 && posPlatte1.y == 0) {
			return steps;
		}

		puzzle.schiebeRandom();

		System.out.println(puzzle);

		return loeseRec(puzzle, ++steps);
	}
}
