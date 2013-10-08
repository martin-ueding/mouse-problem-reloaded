# Copyright © 2011-2013 Martin Ueding <dev@martin-ueding.de>

mouseproblemreloaded.jar: Mausproblem.class
	jar -cfm $@ manifest.txt *.class *.properties

Mausproblem.class: *.java
	javac -encoding UTF-8 Mausproblem.java

install:
	install -d "$(DESTDIR)/usr/share/mouse-problem-reloaded"
	install -m 644 mouseproblemreloaded.jar -t "$(DESTDIR)/usr/share/mouse-problem-reloaded"
	install -d "$(DESTDIR)/usr/share/applications"
	install -m 644 mouseproblemreloaded.desktop -t "$(DESTDIR)/usr/share/applications"

clean:
	$(RM) *.class *.jar
