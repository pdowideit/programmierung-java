package h07;

/**
 * Strategie im Gefangenendilemma
 * 
 * Verrät oder kooperiert aufgrund eines 50:50-Zufallsentscheids.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Random implements GefangenenStrategie {

	@Override
	public boolean getNextDecision() {
		java.util.Random random = new java.util.Random();
		if (random.nextBoolean()) {
			return true;
		}
		return false;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		return;
	}

}
