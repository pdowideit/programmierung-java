package p06;

import java.util.Locale;

public class BenutzerFormat implements BruchFormat {
	private String format;
	private Locale locale = Locale.GERMAN;

	public BenutzerFormat(String format) {
		this.format = format;
	}

	public BenutzerFormat(String format, Locale locale) {
		this.format = format;
		this.locale = locale;
	}

	@Override
	public String bruchToString(int zaehler, int nenner) {
		double decimal = ((double) zaehler) / nenner;
		return String.format(locale, this.format, decimal);
	}

}
