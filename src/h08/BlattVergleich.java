package h08;

import java.util.Comparator;

/**
 * Comparator zum Vergleich zweier Heads-Up Poker Blaetter
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class BlattVergleich implements Comparator<Blatt> {

	@Override
	public int compare(Blatt b1, Blatt b2) {
		int drillingValB1 = isDrilling(b1);
		int drillingValB2 = isDrilling(b2);

		int paarValB1 = isPaar(b1);
		int paarValB2 = isPaar(b2);

		int cardSumB1 = getCardSum(b1);
		int cardSumB2 = getCardSum(b2);

		// ein drilling
		if (drillingValB1 == -1 && drillingValB2 != -1) {
			return -1;
		}
		if (drillingValB2 == -1 && drillingValB1 != -1) {
			return 1;
		}

		// beide drillinge
		if (drillingValB1 != -1 && drillingValB2 != -1) {
			Integer.compare(drillingValB1, drillingValB2);
		}

		// ein paar
		if (paarValB1 != -1 && paarValB2 == -1) {
			return 1;
		}
		if (paarValB2 != -1 && paarValB1 == -1) {
			return -1;
		}

		// beide paar
		if (paarValB1 != -1 && paarValB2 != -1) {
			int compare = Integer.compare(paarValB1, paarValB2);
			if (compare != 0) {
				return compare;
			}

			if (paarValB1 == paarValB2) {
				// vgl. dritte karte
				int thirdB1 = -1;
				for (int karte : b1.getKarten()) {
					if (karte != paarValB1) {
						thirdB1 = karte;
						break;
					}
				}

				int thirdB2 = -1;
				for (int karte : b2.getKarten()) {
					if (karte != paarValB2) {
						thirdB2 = karte;
						break;
					}
				}

				Integer.compare(thirdB1, thirdB2);
			}
		}

		// wenn keiner der anderen faelle zutrifft vergleiche kartensummen
		return Integer.compare(cardSumB1, cardSumB2);

	}

	private int isDrilling(Blatt b) {
		int x = b.getKarten()[0];
		for (int karte : b.getKarten()) {
			if (karte != x) {
				return -1;
			}
		}
		return x;
	}

	private int isPaar(Blatt b) {
		int[] karten = b.getKarten();

		if (karten[0] == karten[1])
			return karten[0];
		if (karten[1] == karten[2])
			return karten[1];
		if (karten[0] == karten[2])
			return karten[0];

		return -1;
	}

	private int getCardSum(Blatt b) {
		int res = 0;
		for (int karte : b.getKarten()) {
			res += karte;
		}
		return res;
	}

}
