# Copyright © 2011-2013 Martin Ueding <dev@martin-ueding.de>

mouseproblemreloaded.jar: Mausproblem.class
	jar -cfm $@ manifest.txt *.class *.properties

Mausproblem.class: *.java
	javac -encoding UTF-8 Mausproblem.java

clean:
	$(RM) *.class *.jar
