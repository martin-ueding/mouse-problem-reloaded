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

import java.util.TimerTask;


public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		for (int i = 0; i < Partikelkasten.p.length; i++) {
			Partikelkasten.p[i].move();
		}

		Partikelkasten.anzeige.repaint();
	}

}
