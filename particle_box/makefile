# Copyright © 2011-2013 Martin Ueding <dev@martin-ueding.de>

particlebox.jar: Partikelkasten.class
	jar -cfm $@ manifest.txt *.class *.java makefile

Partikelkasten.class: *.java
	javac -encoding UTF-8 Partikelkasten.java

clean:
	$(RM) *.class *.jar
