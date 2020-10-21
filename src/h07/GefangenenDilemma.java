package h07;

/**
 * Repraesentiert ein Gefangenendilemma mit Entscheidungsstrategien
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class GefangenenDilemma {
	/**
	 * Ausgewaehlte Strategien
	 */
	private GefangenenStrategie a, b;

	/**
	 * Initialisiert ein neues Gefangenendilemma mit den uebergebenen Strategien
	 * 
	 * @param a Strategie S1
	 * @param b Strategie S2
	 */
	public GefangenenDilemma(GefangenenStrategie a, GefangenenStrategie b) {
		String aStrat = a.getClass().getSimpleName();
		String bStrat = b.getClass().getSimpleName();

		System.out.println("Strategie A: " + aStrat);
		System.out.println("Strategie B: " + bStrat);

		this.a = a;
		this.b = b;
	}

	/**
	 * Fuehrt das Gefangenendilemma ueber eine waehlbare Anzahl an Iterationen mit
	 * den eingestellten Strategien aus Gibt den Sieger als Zahlenwert zurück
	 * 
	 * @param n Anzahl Iterationen
	 * @return -1 := S1 gewinnt; 1 := S2 gewinnt; 0 := unentschieden
	 */
	public int spiele(int n) {
		int aPunkte = 0;
		int bPunkte = 0;
		for (int i = 0; i < n; i++) {
			boolean aDecision = a.getNextDecision();
			boolean bDecision = b.getNextDecision();

			a.setOpponentsLastDecision(bDecision);
			b.setOpponentsLastDecision(aDecision);

			if (aDecision && bDecision) {
				aPunkte += 2;
				bPunkte += 2;
			} else if (!aDecision && !bDecision) {
				aPunkte += 4;
				bPunkte += 4;
			} else if (aDecision && !bDecision) {
				aPunkte += 6;
				bPunkte += 1;
			} else if (!aDecision && bDecision) {
				aPunkte += 1;
				bPunkte += 6;
			}
		}

		String sieger = "S" + (aPunkte < bPunkte ? "1" : "2");

		System.out.println("Strafpunkte S1=" + aPunkte);
		System.out.println("Strafpunkte S2=" + bPunkte);
		if (!(aPunkte == bPunkte)) {
			System.out.println(sieger + " gewinnt!");
		} else {
			System.out.println("Unentschieden!");
		}
		System.out.println();
		return Integer.compare(aPunkte, bPunkte);
	}

}
