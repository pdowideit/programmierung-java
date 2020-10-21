package h07;

/**
 * Strategie im Gefangenendilemma
 * 
 * Kooperiert in der ersten Runde und verrät, falls der vorherige Zug des
 * Mitspielers anders als der eigene war. Kooperiert, wenn in der Vorrunde beide
 * Spieler kooperierten oder beide verrieten. Dies führt zu einem Wechsel des
 * Verhaltens, wenn der Gewinn der Vorrunde klein war, aber zum Beibehalten des
 * Verhaltens, wenn der Gewinn groß war.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Pavlov implements GefangenenStrategie {
	private boolean opponentLastDecision;
	private boolean ownLastDecision;

	private boolean firstRound = true;

	@Override
	public boolean getNextDecision() {
		if (firstRound) {
			firstRound = false;
			this.ownLastDecision = true;
			return true;
		}

		if (ownLastDecision != opponentLastDecision) {
			return false;
		}

		return true;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponentLastDecision = decision;
	}

}
