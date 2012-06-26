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

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MyMouseMotionListener implements MouseMotionListener {

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

		Partikelkasten.p[0].xb = e.getX();
		Partikelkasten.p[0].yb = e.getY();

	}

}
