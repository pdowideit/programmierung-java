package h07;

/**
 * Strategie im Gefangenendilemma
 * 
 * Kooperiert solange, bis der Mitspieler zum ersten Mal verrät. Verrät danach
 * immer. Kooperiert bis zum ersten Vertrauensmissbrauch. Sehr nachtragend.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Spite implements GefangenenStrategie {
	private boolean wurdeVerraten = false;

	@Override
	public boolean getNextDecision() {
		return !wurdeVerraten;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if (!wurdeVerraten) {
			if (!decision) {
				wurdeVerraten = true;
			}
		}
	}

}
