particlebox.jar: Partikelkasten.class
	jar -cfm particlebox.jar manifest.txt *.class

Partikelkasten.class: *.java
	javac Partikelkasten.java
