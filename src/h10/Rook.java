package h10;

import java.util.ArrayList;

/**
 * Repraesentiert eine Turm Figur eines Standart Schachspiels
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Rook extends Chessman {

	/**
	 * Initialisiert eine Turm Figur an der uebergebenen Position
	 * 
	 * @param pos Position des Turm
	 */
	public Rook(Position pos) {
		super(pos);
	}

	@Override
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> moveList = new ArrayList<Position>();

		int x = this.getPosition().getX();
		int y = this.getPosition().getY();

		for (int i = 1; i <= 8; i++) {
			moveList.add(new Position(x, i));
			moveList.add(new Position(i, y));
		}

		moveList.remove(new Position(x, y));

		return moveList;
	}

}
