package p06;

public class DoubleFormat implements BruchFormat {

	@Override
	public String bruchToString(int zaehler, int nenner) {
		double decimal = ((double) zaehler) / nenner;
		return String.valueOf(decimal);
	}

}
