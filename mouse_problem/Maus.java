// Copyright © 2007, 2012-2013 Martin Ueding <dev@martin-ueding.de>

import java.awt.Color;

/**
 * Stellt eine Maus dar.
 *
 */

public class Maus {
	private static double speed = 7.0;

	/**
	 * Setzt die Geschwindigkeit wieder auf 4
	 */

	public static void resetSpeed() {
		speed = 4.0;
	}

	private Maus vor;

	public Color farbe, farbeSchwach;

	private double xp, yp;

	/**
	 * Setzt die Farbe einer Maus
	 *
	 * @param r Rotanteil
	 * @param g Grünanteil
	 * @param b Blauanteil
	 */

	public void setColor(int r, int g, int b) {
		farbe = new Color(r, g, b);
		farbeSchwach = new Color(r / 2, g / 2, b / 2);
	}

	/**
	 * Setzt die Position einer Maus
	 *
	 * @param x X-Koopdinate
	 * @param y Y-Koordinate
	 */

	public void setPos(int x, int y) {
		xp = x;
		yp = y;
	}

	/**
	 * Setzt die Farbe auf weiß
	 */

	public void heller() {
		farbe = new Color(255, 255, 255);
	}

	/**
	 * @return X-Koopdinate
	 */

	public double getX() {
		return xp;
	}

	/**
	 * @return Y-Koordinate
	 */

	public double getY() {
		return yp;
	}

	/**
	 * Setzt den Vordermann der Maus
	 */

	public void setVor(Maus m) {
		vor = m;
	}

	/**
	 * Bewegt die Maus. Der Abstand zum Vorgänger wird berechnet und ein Teil der Strecke wird zurückgelegt.
	 */

	public void move() {
		double x, y;

		x = vor.getX() - getX();
		y = vor.getY() - getY();

		double c = speed / Math.sqrt(x * x + y * y);

		xp += c * x;
		yp += c * y;


		if (speed >= 1.5) {
			speed /= 1.000003;
		}
	}

	public static double getSpeed() {
		return speed;
	}
}
