package h07;

/**
 * Strategie im Gefangenendilemma
 * 
 * Spielt periodisch die Folge kooperieren/kooperieren/verraten. Diese Strategie
 * versucht, den Mitspieler durch zweimaliges Kooperieren in Sicherheit zu
 * wiegen, um ihn dann einmal auszunehmen.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class PerKind implements GefangenenStrategie {
	int coopCount = 0;

	@Override
	public boolean getNextDecision() {
		if (coopCount < 2) {
			coopCount++;
			return true;
		} else {
			coopCount = 0;
			return false;
		}
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		return;
	}

}
