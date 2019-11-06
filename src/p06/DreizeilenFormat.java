package p06;

import org.apache.commons.lang3.StringUtils;

public class DreizeilenFormat implements BruchFormat {

	@Override
	public String bruchToString(int zaehler, int nenner) {
		int maxLength = Math.max(String.valueOf(zaehler).length(), String.valueOf(nenner).length());
		String format = "%" + maxLength + "d\n" + StringUtils.repeat('-', maxLength) + "\n%" + maxLength + "d";
		return String.format(format, zaehler, nenner);
	}
}
