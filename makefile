# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

particlebox.jar: Partikelkasten.class
	jar -cfm $@ manifest.txt *.class

Partikelkasten.class: *.java
	javac Partikelkasten.java

clean:
	$(RM) *.class *.jar
