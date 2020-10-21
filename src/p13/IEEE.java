package p13;

public class IEEE {
	public static void main(String[] args) {
		System.out.println(fromIEEEToFloat("0/10010001/10000010000000000000000"));
	}

	public static float fromIEEEToFloat(String eingabe) {
		String[] parts = eingabe.split("/");

		boolean positive = parts[0].equals("0");

		int exponent = -127;
		for (int i = parts[1].length() - 1; i >= 0; i--) {
			exponent += Math.pow(2, i) * Integer.valueOf(parts[1].toCharArray()[i] + "");
		}

		double mantisse = 0.0;
		for (int i = parts[2].length() - 1; i >= 0; i--) {
			mantisse += Math.pow(0.5, i) * Integer.valueOf(parts[2].toCharArray()[i] + "");
		}

		float res = (float) (Math.pow(2, exponent) * mantisse);

		if (!positive)
			res *= -1;

		return res;
	}
}
