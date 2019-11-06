package h03;

/**
 * Enthaelt ein Datum und einen dazugehoerigen Goldpreis in Euro je Feinunze.
 */
public class GoldTagespreis {
	public String datum;
	public double preis;

	/**
	 * Erhaelt ein Datum und den dazugehoerigen Goldpreis
	 * 
	 * @param datum Das Datum an dem der Preis aktuell war
	 * @param preis Der Goldpreis am jeweiligen Datum
	 */
	public GoldTagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}

	public String toString() {
		return datum + ": " + preis + " Euro je Feinunze";
	}
}
