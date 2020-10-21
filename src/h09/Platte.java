package h09;

/**
 * Repraesentiert eine Platte mit einem Zahlenwert
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Platte {
	/**
	 * Wert der Platte
	 */
	int val; // 0 < val < 16

	/**
	 * Initialisiert eine Platte mit dem ubergebenen Wert. Gibt Fehler aus wenn der
	 * Wert der Platte im aktuellen Spielplan nicht existiert.
	 * 
	 * @param val Wert der Platte
	 */
	public Platte(int val) {
		super();
		this.val = val;
		if (!(1 <= val && val <= 15)) {
			throw new WrongNumberException(val);
		}
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Platte other = (Platte) obj;
		if (val != other.val)
			return false;
		return true;
	}

}
