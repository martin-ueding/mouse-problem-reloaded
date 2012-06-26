// Copyright (c) Martin Ueding <dev@martin-ueding.de>

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Partikelkasten {

	static Partikel[] p;
	static Anzeige anzeige;

	static int w = 1024, h = 768;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		w = d.width;
		h = d.height;

//		p = new Partikel[w*h/5242];
		p = new Partikel[Integer.parseInt(JOptionPane.showInputDialog("Anzahl der Objekte"))];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Partikel();
			if (i != 0) {
				p[i].vor = p[i - 1];
			}
		}
		p[0].vor = p[p.length - 1];

		anzeige = new Anzeige(p);
		JFrame frame = new JFrame();
		frame.setSize(w, h);
		frame.add(anzeige);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);

		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 500, 50);


		GraphicsDevice myDevice = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (myDevice.isFullScreenSupported()) {
			frame.setUndecorated(true);
			frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
			myDevice.setFullScreenWindow(frame);

			frame.setLocation(0, 0);

			frame.setVisible(true);
		}
		else {
			System.exit(0);
		}

	}

}
