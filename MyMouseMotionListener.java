package de.martin_ueding.mathematik.partikelkasten;

// Copyright (c) 2009 Martin Ueding [mu@martin-ueding.de]

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