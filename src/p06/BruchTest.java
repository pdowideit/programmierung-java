package p06;

import java.util.Locale;

public class BruchTest {
	public static void main(String[] args) {
		Bruch b1 = new Bruch(2121345343, 3);

		b1.setFormat(new DoubleFormat());
		System.out.println(b1);

		b1.setFormat(new SchraegstrichFormat());
		System.out.println(b1);

		b1.setFormat(new BenutzerFormat("%.2f", Locale.US));
		System.out.println(b1);
		
		b1.setFormat(new BenutzerFormat("%.2f", Locale.GERMAN));
		System.out.println(b1);

		b1.setFormat(new DreizeilenFormat());
		System.out.println(b1);
	}
}
