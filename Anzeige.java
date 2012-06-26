/*
 * Copyright (c) 2007, 2012 Martin Ueding <dev@martin-ueding.de>
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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Anzeige extends JPanel {

	Partikel[] p;

	public Anzeige(Partikel[] x) {

		p = x;
	}

	protected void paintComponent(Graphics h) {

		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));


		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int i = 0; i < p.length; i++) {
			g.setColor(p[i].c);
			g.drawLine((int)p[i].x, (int)p[i].y, (int)p[i].xb, (int)p[i].yb);
		}
	}

}
