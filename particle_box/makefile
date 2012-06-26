# Copyright (c) 2011-2012 Martin Ueding <dev@martin-ueding.de>

particlebox.jar: Partikelkasten.class
	jar -cfm $@ manifest.txt *.class *.java makefile

Partikelkasten.class: *.java
	javac Partikelkasten.java

clean:
	$(RM) *.class *.jar
