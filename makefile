mouseproblemreloaded.jar: Mausproblem.class
	jar -cfm mouseproblemreloaded.jar manifest.txt *.class *.properties

Mausproblem.class: *.java
	javac Mausproblem.java
