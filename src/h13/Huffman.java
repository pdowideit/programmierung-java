package h13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasse zur Decodierung eines Huffman Codes.
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class Huffman {
	/**
	 * Dateiname & -pfad der Datei des Huffman Codes
	 */
	private static final String messageFile = "message.txt";

	/**
	 * Funktion zum Test der Huffman Decodierung.
	 * 
	 * @param args nicht verwendet
	 */
	public static void main(String[] args) {
		File f = new File(messageFile);
		System.out.println(decode(f));
	}

	/**
	 * Die Funktion decodiert einen Huffman Code eines speziellen Formats aus einer
	 * Datei (beinhaltet Text und Code) und gibt den decodierten Text zurueck. <br>
	 * <br>
	 * Format: <br>
	 * sZeile 1: Nachricht <br>
	 * Zeile 2-27: Codes pro Zeichen <br>
	 * Zeile 28: Code fuer Leerzeichen <br>
	 * 
	 * @param f Datei mit Huffman Code im beschriebenen Format
	 * @return Decodierter Klartext
	 */
	public static String decode(File f) {
		// init decoding map
		Map<String, Character> decodingMap = new HashMap<String, Character>();
		// init return object
		String word = "";

		// read file through try with resources
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;

			// message stored in the first line
			String message = "";
			// idx of current line
			int lineIdx = 1;
			// process each line
			while ((line = br.readLine()) != null) {
				switch (lineIdx) {
				// first line is message
				case 1:
					message = line;
					break;
				// last line is code for space sign
				case 28:
					decodingMap.put(line, ' ');
					break;
				default:
					// every other line is the character correspoding to the current line (starting
					// at 2)
					if (!line.isEmpty())
						decodingMap.put(line, (char) ((lineIdx - 1) + 64));
					break;

				}
				// increment line idx
				lineIdx++;
			}

			// if file with huffman code has too many lines it is in wrong format, throw
			// exception in that case
			if (lineIdx - 1 > 28) {
				throw new IllegalArgumentException();
			}

			// text to decode, will get longer until the text is found in decoding map
			String decode = "";
			for (char c : message.toCharArray()) {
				// append char to decoding text
				decode += c;
				// check if decoding text is in decoding map
				if (decodingMap.containsKey(decode)) {
					// append decoded character to result word
					word += decodingMap.get(decode);
					// reset decoding text
					decode = "";
				}
			}

		} catch (IOException e) {
			// if thrown print stack trace of IOException for error analysis
			e.printStackTrace();
		}

		// return object
		return word;
	}
}
