package p04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class JavaCode {
	private List<String> code = new ArrayList<String>();

	public void ladeCode(File f) throws FileNotFoundException {
		Scanner sc = new Scanner(f);
		ladeCode(sc);
		sc.close();
	}

	private void ladeCode(Scanner sc) {
		code = new ArrayList<String>();
		while (sc.hasNextLine()) {
			code.add(sc.nextLine());
		}
	}

	public void ladeCode(URL url) {
		URLConnection conn;
		Object content = null;

		try {
			conn = url.openConnection();
			content = conn.getContent();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (content != null) {
			Scanner sc = new Scanner((InputStream) content);
			ladeCode(sc);
			sc.close();
		}
	}

	public void ladeCode() throws FileNotFoundException {
		File file = null;

		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		} else {
			throw new FileNotFoundException("Auswahl abgebrochen");
		}

		ladeCode(file);
	}

	public void schreibeCode(File f) throws IOException {
		PrintWriter w = new PrintWriter(f);
		schreibeCode(w);
		w.close();
	}

	private void schreibeCode(PrintWriter pw) {
		for (String line : code) {
			boolean isEmptyLine = line.replaceAll(" ", "").replaceAll("\t", "").isEmpty();
			if (!isEmptyLine) {
				pw.write(line + "\n");
			}
		}
	}

	public void schreibeCode() throws IOException {
		File file = null;

		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
		int state = fc.showSaveDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		} else {
			throw new FileNotFoundException("Auswahl abgebrochen");
		}

		schreibeCode(file);
	}


	public void entferneKommentare() {
		boolean commentBlock = false;
		int i = 0;
		for (String line : code) {
			if (commentBlock) {
				if (line.contains("*/")) {
					int idx = line.indexOf("*/");
					line = line.substring(idx + 2, line.length());
					commentBlock = false;
				} else {
					code.set(i, "");
					i++;
					continue;
				}
			}

			if (line.contains("/*")) {
				int idx = line.indexOf("/*");
				line = line.substring(0, idx);
				commentBlock = true;
			} else if (line.contains("//")) {
				int idx = line.indexOf("//");
				line = line.substring(0, idx);
			}

			code.set(i, line);
			i++;
		}
	}

}
