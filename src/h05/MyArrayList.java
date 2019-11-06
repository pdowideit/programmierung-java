package h05;

import java.util.Arrays;

/**
 * Klasse die eine Liste an int Werten repraesentiert und Funktionen zum
 * arbeiten mit dieser Liste beinhaltet
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class MyArrayList {
	private int[] arr = new int[10];
	private int size = 0;

	/**
	 * Fuegt ein neues Objekt hinten an die Liste an Erhöht die Groesse der Liste
	 * wenn noetig
	 * 
	 * @param i Neues Objekt
	 */
	public void add(int i) {
		if (size >= arr.length) {
			int[] newarr = new int[size * 2];
			System.arraycopy(arr, 0, newarr, 0, size);
			arr = newarr;
		}

		arr[size] = i;
		size++;
	}

	/**
	 * Gibt den Wert an der uebergebenen Stelle zurueck
	 * 
	 * @param pos Stelle
	 * @return int-Wert an der Stelle
	 */
	public int get(int pos) {
		if (0 <= pos && pos < size) {
			return arr[pos];
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * Gibt die Liste als String aus Schneidet dabei nicht belegte Felder ab
	 */
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(arr, 0, size));
	}

	/**
	 * Leert die Liste
	 */
	public void clear() {
		arr = new int[10];
		size = 0;
	}

	/**
	 * Gibt die Anzahl der Werte in der Liste zurueck
	 * 
	 * @return Anzahl Werte
	 */
	public int size() {
		return size;
	}

	/**
	 * Gibt die aktuelle Kapazitaet der Liste zurueck
	 * 
	 * @return Kapazitaet der Liste
	 */
	public int capacity() {
		return arr.length;
	}

	/**
	 * Klont die Liste in ein neues Listen Objekt und gibt diese zurueck
	 * 
	 * @return Geklonte Liste
	 */
	public MyArrayList clone() {
		MyArrayList clone = new MyArrayList();
		for (int i : arr) {
			clone.add(i);
		}
		clone.size = size;
		return clone;
	}

	/**
	 * Fuegt einen neuen Wert an der gewuenschten Stelle ein
	 * 
	 * @param i   Neuer Wert
	 * @param pos Gewuenschte Stelle
	 */
	public void add(int i, int pos) {
		if (pos < 0 || pos > size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (pos == size) {
			add(i);
			return;
		}

		int temp = arr[size - 1];
		for (int a = size - 1; a > pos; a--) {
			arr[a] = arr[a - 1];
		}
		arr[pos] = i;
		add(temp);

	}

	/**
	 * Loescht den Wert am uebergebenen Index
	 * 
	 * @param pos Index des zu loeschenden Wertes
	 */
	public void delete(int pos) {
		if (pos < 0 || pos > size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		for (int i = pos; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		size--;

		if (size < arr.length / 3) {
			int[] newarr = new int[arr.length / 2];
			System.arraycopy(arr, 0, newarr, 0, size);
			arr = newarr;
		}
	}
}
