package h07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Testet das Spiel in allen moeglichen Kombinationen ueber mehrere Iterationen
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Spiel {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		int roundCount = 100000;
		int perGameIterations = 100;

		List<Class<? extends GefangenenStrategie>> strats = new ArrayList<Class<? extends GefangenenStrategie>>(
				Arrays.asList(Random.class, Pavlov.class, Spite.class, TitForTat.class, PerKind.class));

		Map<String, Integer> stratWins = new HashMap<String, Integer>();

		for (Class<? extends GefangenenStrategie> strat : strats) {
			stratWins.put(strat.getSimpleName(), 0);
		}

		int drawCount = 0;

		for (Class<? extends GefangenenStrategie> stratA : strats) {
			GefangenenStrategie a = stratA.newInstance();
			for (Class<? extends GefangenenStrategie> stratB : strats) {
				if (stratA.getSimpleName().equals(stratB.getSimpleName()))
					continue;
				
				GefangenenStrategie b = stratB.newInstance();

				for (int i = 0; i < perGameIterations; i++) {
					GefangenenDilemma dilemma = new GefangenenDilemma(a, b);
					int res = dilemma.spiele(roundCount);

					if (res == 1) {
						int currWins = stratWins.get(stratB.getSimpleName());
						stratWins.put(stratB.getSimpleName(), ++currWins);
					} else if (res == -1) {
						int currWins = stratWins.get(stratA.getSimpleName());
						stratWins.put(stratA.getSimpleName(), ++currWins);
					} else {
						drawCount++;
					}
				}
			}
		}

		System.out.println(stratWins.toString());
		System.out.println(drawCount + " draws.");
	}
}
