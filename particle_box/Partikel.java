/*
 * Copyright (c) 207, 2012 Martin Ueding <dev@martin-ueding.de>
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see http://www.gnu.org/licenses/.
 */

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
