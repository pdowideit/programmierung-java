package h11;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * Visualisiert die berechnete Kochkurve
 * 
 * @author Paul Dowideit, Tim Bartel, Andreas Graewingholt
 *
 */
public class KochCanvas extends Canvas {
	/**
	 * Berechnete Punkte
	 */
	public static List<Vector> points = new ArrayList<Vector>();

	/**
	 * Zeigt das Canvas an
	 */
	public static void run() {
		JFrame frame = new JFrame("Koch Kurve");
		Canvas canvas = new KochCanvas();
		canvas.setSize(3000, 3000);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Malt die Koordinaten auf den Canvas
	 */
	public void paint(Graphics g) {
		for (Vector point : points) {
			g.fillOval((int) point.x, (int) point.y, 5, 5);
		}
	}
}
