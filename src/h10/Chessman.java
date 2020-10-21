package h10;

import java.util.ArrayList;

/**
 * Repraesentiert eine Schachfigur mit allen Grundfunktionalitaeten die eine
 * solche bieten muss
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public abstract class Chessman {
	/**
	 * Aktuelle Position der Figur
	 */
	private Position position;

	/**
	 * Initialisiert eine neue Schachfigur an der uebergebenen Position Ueberprueft
	 * auﬂerdem, ob die uebergebene Position valide ist.
	 * 
	 * @param pos Position
	 */
	public Chessman(Position pos) {
		this.position = pos;

		if (!Position.isValid(pos.getX(), pos.getY())) {
			throw new WrongPositionException(pos);
		}
	}

	/**
	 * Gibt die aktuelle Position der Schachfigur zurueck
	 * 
	 * @return Aktuelle Position der Figur
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Bewegt die Figur an die uebergebene Stelle, sofern moeglich. Wirft einen
	 * Laufzeitfehler, wenn der Zug nicht moeglich ist.
	 * 
	 * @param pos Neue Position der Figur
	 */
	public void moveTo(Position pos) {
		if (canMoveTo(pos)) {
			this.position = pos;
		} else {
			throw new WrongMoveException(pos);
		}
	}

	/**
	 * Gibt eine Liste an Positionen zurueck, die fuer die aktuelle Figur erreichbar
	 * sind.
	 * 
	 * @return Liste an erreichbaren Positionen
	 */
	public abstract ArrayList<Position> getMoveList();

	/**
	 * Gibt einen Wahrheitswert anhand einer Position zurueck der indiziert, ob die
	 * Figur sich an die Position bewegen kann.
	 * 
	 * @param pos Position
	 * @return Wahrheitswert, ob die Position fuer die Figur erreichbar ist
	 */
	public boolean canMoveTo(Position pos) {
		return getMoveList().contains(pos);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": [" + position + "]";
	}

}
