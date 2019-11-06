package h01.a01;

import java.util.Arrays;

/**
 * Repräsentiert eine komplexe Zahl mit Real- und Imaginärteil.
 * 
 */
public class KomplexeZahl {
	/**
	 * Realteil der komplexen Zahl
	 */
	private double realTeil;
	/**
	 * Imaginärteil der komplexen Zahl
	 */
	private double imagTeil;

	/**
	 * Erzeugt eine komplexe Zahl mit dem gegebenen Realteil und Imaginärteil.
	 * 
	 * @param real der Realteil der komplexen Zahl
	 * @param imag der Imaginaerteil der komplexen Zahl
	 */
	public KomplexeZahl(double real, double imag) {
		this.realTeil = real;
		this.imagTeil = imag;
	}

	/**
	 * Copy Kontruktor für komplexe Zahlen
	 * 
	 * @param x Komplexe Zahl die geklont werden soll
	 */
	public KomplexeZahl(KomplexeZahl x) {
		this.realTeil = x.realTeil;
		this.imagTeil = x.imagTeil;
	}

	/**
	 * Setzt den Realteil der komplexen Zahl
	 * 
	 * @param real Realteil
	 */
	public void setReal(double real) {
		this.realTeil = real;
	}

	/**
	 * Setzt den Imaginärteil der komplexen Zahl
	 * 
	 * @param imag Imaginärteil
	 */
	public void setImag(double imag) {
		this.imagTeil = imag;
	}

	/**
	 * Gibt den Realteil der Komplexen Zahl zurück
	 * 
	 * @return realTeil Realteil der komplexen Zahl
	 */
	public double getReal() {
		return this.realTeil;
	}

	/**
	 * Gibt den Imaginärteil der Komplexen Zahl zurück
	 * 
	 * @return imagTeil Imaginärteil der komplexen Zahl
	 */
	public double getImag() {
		return this.imagTeil;
	}

	/**
	 * Methode die den Betrag der aktuellen komplexen Zahl berechnet und zurückgibt
	 * Wurzel ( Realteil^2 + Imaginärteil^2)
	 * 
	 * @return res Betrag der komplexen Zahl
	 */
	public double getBetrag() {
		return Math.sqrt((Math.pow(this.realTeil, 2) + Math.pow(this.imagTeil, 2)));
	}

	/**
	 * Methode um eine komplexe Zahl in Polarkoordianten umzurechnen
	 * 
	 * @return res Array welches an erster Stelle den Radius und an zweiter Stelle
	 *         den Winkel phi enthält
	 */
	public double[] polar(KomplexeZahl z) {
		double[] res = new double[2];
		res[0] = z.getBetrag();
		res[1] = Math.atan(this.imagTeil / this.realTeil);
		return res;
	}

	/**
	 * Methode die die zweite Wurzel aus einer komplexen Zahl nach der Formel von de
	 * Moivre berechnet und diese als Array zurückgibt
	 * 
	 * @return res Gibt ein Array an komplexen Zahl zurück
	 */
	public KomplexeZahl[] getWurzel() {
		KomplexeZahl[] res = new KomplexeZahl[2];
		double radius = this.getBetrag();
		double phi = Math.atan(this.imagTeil / this.realTeil);

		double vorfaktor = Math.sqrt(radius);

		for (int i = 0; i < 2; i++) {
			double r = vorfaktor * Math.cos((phi + 2 * Math.PI * i) / 2);
			double im = vorfaktor * Math.sin((phi + 2 * Math.PI * i) / 2);
			res[i] = new KomplexeZahl(r, im);
		}
		return res;
	}

	/**
	 * Methode die zur aktuellen komplexen Zahl die übergebene komplexe Zahl addiert
	 * 
	 * @param z komplexe Zahl die addiert wird
	 */
	public void addiere(KomplexeZahl z) {
		this.realTeil = this.realTeil + z.getReal();
		this.imagTeil = this.imagTeil + z.getImag();
	}

	/**
	 * Methode die zur aktuellen komplexen Zahl die übergebene komplexe Zahl addiert
	 * und das Ergebnis zurückgibt Die aktuelle komplexe Zahl bleibt unverändert
	 * 
	 * @param z komplexe Zahl die addiert wird
	 * 
	 * @return Ergebnis der Addition der aktuellen komplexen Zahl und des Parameters
	 */
	public KomplexeZahl getSumme(KomplexeZahl z) {
		KomplexeZahl res = new KomplexeZahl(this.realTeil + z.getReal(), this.imagTeil + z.getImag());
		return res;
	}

	/**
	 * Methode die die aktuelle komplexe Zahl mit der übergebenen komplexen Zahl
	 * multipliziert z1 * z2 = (a1*a2 - b1*b2) + i* (b1*a2 + a1*b2)
	 * 
	 * @param z komplexe Zahl mit der multipliziert wird
	 */
	public void multipliziere(KomplexeZahl z) {
		this.realTeil = (this.realTeil * z.getReal() - this.imagTeil * z.getImag());
		this.imagTeil = (this.imagTeil * z.getReal() + this.realTeil * z.getImag());
	}

	/**
	 * Methode die die aktuelle komplexe Zahl mit der übergebenen komplexen Zahl
	 * Verändert dabei die aktuelle komplexe Zahl nicht sondern gibt das Ergebnis
	 * zurück
	 * 
	 * @param z komplexe Zahl mit der multipliziert wird
	 * 
	 * @return Ergebnis der Multiplikation der übergebenen komplexen Zahl und der
	 *         aktuellen komplexen Zahl
	 */
	public KomplexeZahl getProdukt(KomplexeZahl z) {
		double re = (this.realTeil * z.getReal() - this.imagTeil * z.getImag());
		double im = (this.imagTeil * z.getReal() + this.realTeil * z.getImag());
		KomplexeZahl res = new KomplexeZahl(re, im);
		return res;
	}

	@Override
	public String toString() {
		String res = "";
		if (this.imagTeil < 0) {
			res = this.realTeil + " - " + Math.abs(this.imagTeil) + " i";
		} else if (this.imagTeil == 0) {
			res += this.realTeil;
		} else if (this.imagTeil > 0) {
			res = this.realTeil + " + " + Math.abs(this.imagTeil) + " i";
		}
		return res;
	}

	public static void main(String[] args) {
		KomplexeZahl z = new KomplexeZahl(0, 0); // z := 0
		System.out.println("z = " + z);
		z = new KomplexeZahl(1, 0); // z := 1
		System.out.println("z = " + z);
		z = new KomplexeZahl(0, 1); // z := i
		System.out.println("z = " + z);
		z = new KomplexeZahl(-4, 0); // z := -4
		System.out.println("z = " + z);
		KomplexeZahl[] wurzeln = z.getWurzel(); // => 2i und -2i
		System.out.println("sqrt(z) = " + Arrays.toString(wurzeln));
		z = new KomplexeZahl(1, 1); // z := 1+i
		System.out.println("z = " + z);
		double betrag = z.getBetrag();
		System.out.println("|z| = " + betrag); // => sqrt(2) = 1.41...
		KomplexeZahl z2 = new KomplexeZahl(2, 1); // z2 := 2+i
		System.out.println("z2 = " + z2);
		z.addiere(z2);
		System.out.println("z nach Addition von z2 = " + z);
		z.multipliziere(z2);
		System.out.println("z nach Multiplikation von z2 = " + z);
		z2 = z.getProdukt(new KomplexeZahl(-1, 0)); // z2 := -z
		System.out.println("z2 = " + z2);
		KomplexeZahl summe = z.getSumme(z2); // z := z - z2 = 0
		System.out.println("summe = " + summe);
	}
}
