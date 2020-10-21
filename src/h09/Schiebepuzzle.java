package h09;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Repraesentation eines Schiebepuzzles mit der Moeglichkeit Platten zu
 * verschieben
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Schiebepuzzle {
	/**
	 * Map die die aktuellen Positionen aller Platten beinhaltet
	 */
	private Map<Integer, PlattenPosition> plattenPositions;

	/**
	 * Aktuelle freie Position
	 */
	private PlattenPosition freePosition;

	/**
	 * Verschachtelte Arrays, die das Spielfeld repraesentieren
	 */
	private Platte[][] platten;

	/**
	 * Objekt zur Generierung von Zufallswerten
	 */
	private Random random;

	/**
	 * Initialisiert ein geordnetes Schiebepuzzle mit den Platten 1-15
	 */
	public Schiebepuzzle() {
		// init map
		plattenPositions = new HashMap<Integer, PlattenPosition>();

		// init array
		platten = new Platte[4][4];
		for (int a = 0; a <= 3; a++) {
			platten[a] = new Platte[4];
		}

		// init platten positions
		for (int i = 1; i <= 15; i++) {
			Platte platte = new Platte(i);
			int xPos = (i - 1) / 4;
			int yPos = (i - 1) % 4;

			platten[xPos][yPos] = platte;

			PlattenPosition position = new PlattenPosition(xPos, yPos);

			plattenPositions.put(platte.val, position);
		}

		// set free position
		freePosition = new PlattenPosition(3, 3);
	}

	/**
	 * Methode die versucht das Teil an der gegebenen Stelle auf das freie Feld zu
	 * verschieben und einen Fehler wirft, wenn das Teil nicht an die Stelle
	 * verschiebbar ist
	 * 
	 * @param i zu verschiebende Platte
	 * @throws WrongMoveException wenn der Zug nicht moeglich ist
	 */
	public void schiebe(int i) throws WrongMoveException {
		// ueberpruefe ob zug moeglich ist
		if (isVerschiebbar(i)) {
			// wenn ja fuehre zug durch

			// speichert ehemalige position der platte
			PlattenPosition newFreePosition = plattenPositions.get(i);
			// setze platten position auf freies feld
			plattenPositions.replace(i, freePosition);
			platten[freePosition.x][freePosition.y] = new Platte(i);
			// setze freie position auf ehemalige platten position
			freePosition = newFreePosition;
			platten[freePosition.x][freePosition.y] = null;
		} else {
			// wenn nein werfe exception
			throw new WrongMoveException(i);
		}
	}

	/**
	 * Gibt an ob die gegebene Platte verschiebbar ist
	 * 
	 * @param i Platte
	 * @return true:=verschiebbar<br>
	 *         false:=nicht verschiebbar
	 */
	public boolean isVerschiebbar(int i) {
		PlattenPosition plattenPos = plattenPositions.get(i);

		if (plattenPos == null) {
			return false;
		}

		int plattenX = plattenPos.x;
		int plattenY = plattenPos.y;

		int freeX = freePosition.x;
		int freeY = freePosition.y;

		if (Math.abs(plattenX - freeX) == 1 && plattenY == freeY) {
			return true;
		}

		if (Math.abs(plattenY - freeY) == 1 && plattenX == freeX) {
			return true;
		}

		return false;
	}

	/**
	 * Gibt den Wert einer zufaelligen verschiebbaren Platte zurueck
	 * 
	 * @return Wert einer verschiebbaren Platte
	 */
	public int getRandomVerschiebbar() {
		if (random == null) {
			random = new Random();
		}

		int idx;
		do {
			idx = random.nextInt(16);
		} while (!this.isVerschiebbar(idx));

		return idx;
	}

	/**
	 * Fuehrt 100 zufaellige Zuege durch und mischt dadurch das Puzzle
	 */
	public void mische() {
		for (int count = 0; count < 100; count++) {
			schiebeRandom();
		}
	}

	/**
	 * Gibt die Platten Position der Platte mit dem uebergebenen Wert zurueck
	 * 
	 * @param i Wert der Platte
	 * @return Position der Platte
	 */
	public PlattenPosition getPlattenPosition(int i) {
		return plattenPositions.get(i);
	}

	/**
	 * Fuehrt einen zufaelligen moeglichen Zug durch
	 */
	public void schiebeRandom() {
		schiebe(getRandomVerschiebbar());
	}

	public String toString() {
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("-----------------\n");
		for (Platte[] plattenReihe : platten) {
			StringBuilder rowBuilder = new StringBuilder();
			rowBuilder.append("|");
			for (Platte platte : plattenReihe) {
				String val = platte == null ? "" : String.valueOf(platte.val);
				rowBuilder.append(String.format("%3s", val) + "|");
			}
			rowBuilder.append("\n");
			tableBuilder.append(rowBuilder.toString());
			tableBuilder.append("-----------------\n");
		}
		return tableBuilder.toString();
	}

}
