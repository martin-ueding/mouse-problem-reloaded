// Copyright (c) 2007 Martin Ueding <dev@martin-ueding.de>

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JPanel;

/**
 * Dieses JPanel zeigt die Mäuse in Form von Linien an. Es lässt die Mäuse die neuen Positionen ausrechnen
 * und zeigt die Bewegung an.
 *
 * Außerdem werden die Mäuse hier per Konstruktor initialisiert.
 *
 * Copyright: Martin Ueding
 */

public class MausPanel extends JPanel {
	private static final long serialVersionUID = -2293339254320655533L;

	private int ecke;

	private int sx, sy, ex, ey;
	private int tc;
	private int maxIter = 1;

	private int fb, fh;
	
	private int frames;
	
	private Date dtstart = new Date();
	private Date dt = new Date();
	private long messdauer;

	private Maus[] tier;
	
	/**
	 * Dieser Konstruktor legt alle Mäuse auf zufällige Stellen und gibt ihnen Farben.
	 *
	 * @param anz Anzahl der Mäuse
	 * @param a Fensterbreite
	 * @param b Fensterhöhe
	 */

	public MausPanel (int anz, int a, int b) {
		tier = new Maus[anz];
		for (tc = 0; tc < tier.length; tc++) {
			tier[tc] = new Maus();
		}
		
		fb = a; fh = b;


		for (tc = 0; tc < tier.length; tc++) {
			tier[tc].setColor((int)(Math.random()*204+51), (int)(Math.random()*204+51), (int)(Math.random()*204+51));
			tier[tc].setPos((int)(Math.random()*fb), (int)(Math.random()*fh));
		}


		for (tc = 0; tc < tier.length; tc++) {
			tier[tc].setVor(tier[(tc+tier.length-1)%tier.length]);
		}
	}

	/**
	 * Zeichet die Mäuse. Außerdem werden sie hier bewegt und teilweise wieder zurückgesetzt.
	 */

	protected void paintComponent(Graphics g) {
		frames++;
		dt = new Date();
		
		messdauer = dt.getTime() - dtstart.getTime();
		
		g.setColor (new Color(0,0,0));
		g.fillRect(0, 0, getWidth(), getHeight());

		for (tc = 0; tc < tier.length; tc++) {
			g.setColor(tier[tc].farbe);

			sx = (int)tier[tc].getX();
			sy = (int)tier[tc].getY();

			tier[tc].move();

			ex = (int)tier[tc].getX();
			ey = (int)tier[tc].getY();

			g.drawLine(sx, sy, ex, ey);
		}
		for (int anzit = 0; anzit < (int)(1000.0/maxIter); anzit++) {
			if (ecke %4 == 0)
				tier[(int)(Math.random()*(tier.length-1))].setPos(0, 0);
			else if (ecke %4 == 1)
				tier[(int)(Math.random()*(tier.length-1))].setPos(fb, 0);
			else if (ecke %4 == 2)
				tier[(int)(Math.random()*(tier.length-1))].setPos(fb, fh);
			else
				tier[(int)(Math.random()*(tier.length-1))].setPos(0, fh);

			ecke = (ecke+1)%4;
		}

		if (maxIter > 1000) {
			tier[(int)(Math.random()*(tier.length-1))].heller();
		}
		
		g.setColor(Color.WHITE);
		g.drawString("FPS: "+(frames*1000/messdauer), 10, 30);

		maxIter++;
		
		if (frames%100 == 0) {
			dtstart = dt;
			frames = 0;
		}
	}
	
	/**
	 * Gibt an, ob sich die erste Maus innerhalb des Feldes befindet.
	 *
	 * @return Ob die Maus drin ist.
	 */

	public boolean innerhalb () {
		return tier[0].getX() < 0 || tier[0].getX() > fb || tier[0].getY() < 0 || tier[0].getY() > fh;
	}
}
