package h07;

/**
 * Strategie im Gefangenendilemma
 * 
 * Kooperiert in der ersten Runde und kopiert in den nächsten Runden den
 * vorherigen Spielzug des Spielpartners. Diese Strategie ist prinzipiell
 * kooperationswillig, übt aber bei Verrat Vergeltung. Bei erneuter Kooperation
 * des Mitspielers ist sie nicht nachtragend, sondern reagiert ihrerseits mit
 * Kooperation.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class TitForTat implements GefangenenStrategie {

	private boolean oppLastDecision;
	private boolean firstRound = true;

	@Override
	public boolean getNextDecision() {
		if (firstRound) {
			firstRound = false;
			return true;
		}

		return oppLastDecision;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.oppLastDecision = decision;
	}

}
