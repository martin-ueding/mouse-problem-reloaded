// Copyright (c) 2007 Martin Ueding <dev@martin-ueding.de>

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
