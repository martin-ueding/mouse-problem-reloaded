// Copyright © 207, 2012-2013 Martin Ueding <dev@martin-ueding.de>

import java.awt.Color;


public class Partikel {

	double x, y;
	double xb, yb;

	int id;
	static int auto_incr = 0;

	Color c;

	Partikel vor;

	public Partikel() {
		x = (int)(Math.random() * Partikelkasten.w);
		y = (int)(Math.random() * Partikelkasten.h);

		xb = x;
		yb = y;

		c = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));

		id = auto_incr++;
	}

	void move() {
		xb = x;
		yb = y;

		double abstand = Math.sqrt(Math.pow(x - vor.x, 2) + Math.pow(y - vor.y, 2));
		abstand *= 0.2;

		if (abstand != 0) {
			x -= (x - vor.x) / abstand;
			y -= (y - vor.y) / abstand;
		}

		for (int i = 0; i < Partikelkasten.p.length; i++) {
			Partikel test = Partikelkasten.p[i];
			if (test.id != id && (int)test.x == (int)x && (int)test.y == (int)y) {
				test.y = Partikelkasten.h;
				y = 0;

//			 	y = y > Partikelkasten.h/2 ? 0 : Partikelkasten.h;
				x = Math.random() * Partikelkasten.w;
				test.x = Math.random() * Partikelkasten.w;
			}
		}
	}

}
