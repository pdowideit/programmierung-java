package p04;

import java.io.File;
import java.io.IOException;

public class JavaCodeTest {
	public static void main(String[] args) {
		JavaCode c = new JavaCode();
//		try {
//			c.ladeCode(new File("KommentarTest.java"));
//			c.schreibeCode(new File("KommentarTestFile.java"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			c.ladeCode(new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/KommentarTest.java?version=2&modificationDate=1571825161725&api=v2"));
//			c.schreibeCode(new File("KommentarTestURL.java"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			c.ladeCode();
//			c.schreibeCode();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			c.ladeCode(new File("KommentarTest.java"));
			c.entferneKommentare();
			c.schreibeCode(new File("KommentarTestOhneKomm.java"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
