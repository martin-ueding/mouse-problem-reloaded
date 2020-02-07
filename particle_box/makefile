# Copyright © 2011-2013 Martin Ueding <martin-ueding.de>

particlebox.jar: Partikelkasten.class
	jar -cfm $@ manifest.txt *.class *.java makefile

Partikelkasten.class: *.java
	javac -encoding UTF-8 Partikelkasten.java

install:
	install -d "$(DESTDIR)/usr/share/mouse-problem-reloaded"
	install -m 644 particlebox.jar -t "$(DESTDIR)/usr/share/mouse-problem-reloaded"
	install -d "$(DESTDIR)/usr/share/applications"
	install -m 644 particlebox.desktop -t "$(DESTDIR)/usr/share/applications"

clean:
	$(RM) *.class *.jar
