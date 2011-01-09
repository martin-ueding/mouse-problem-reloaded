package de.martin_ueding.mathematik.partikelkasten;

// Copyright (c) 2009 Martin Ueding [mu@martin-ueding.de]

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
