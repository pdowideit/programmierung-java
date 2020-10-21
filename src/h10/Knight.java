package h10;

import java.util.ArrayList;

/**
 * Repraesentiert eine Springer Figur eines Standart Schachspiels
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Knight extends Chessman {

	/**
	 * Initialisiert eine Springer Figur an der uebergebenen Position
	 * 
	 * @param pos Position des Springers
	 */
	public Knight(Position pos) {
		super(pos);
	}

	@Override
	public ArrayList<Position> getMoveList() {
		ArrayList<Position> moveList = new ArrayList<Position>();

		int x = this.getPosition().getX();
		int y = this.getPosition().getY();

		int iters = 0;
		for (int i = -1; iters <= 3; i = i * -1) {
			if (iters < 2) {
				int x1 = x + 2 * i;
				int y1 = y + i;
				int y2 = y - i;

				Position pos1 = new Position(x1, y1);
				Position pos2 = new Position(x1, y2);
				if (!moveList.contains(pos1) && Position.isValid(x1, y1))
					moveList.add(pos1);
				if (!moveList.contains(pos2) && Position.isValid(x1, y2))
					moveList.add(pos2);
			} else {
				int y1 = y + 2 * i;
				int x1 = x + i;
				int x2 = x - i;

				Position pos1 = new Position(x1, y1);
				Position pos2 = new Position(x2, y1);
				if (!moveList.contains(pos1) && Position.isValid(x1, y1))
					moveList.add(pos1);
				if (!moveList.contains(pos2) && Position.isValid(x2, y1))
					moveList.add(pos2);
			}
			iters++;
		}

		return moveList;
	}

}
