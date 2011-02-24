# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

mouseproblemreloaded.jar: Mausproblem.class
	jar -cfm mouseproblemreloaded.jar manifest.txt *.class *.properties

Mausproblem.class: *.java
	javac Mausproblem.java
