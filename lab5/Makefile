# Makefile for lab5
# Matthew Tan
# mxtan
# lab5
# Creates the Makefile for lab 5
# ------------------------------------------------

ComplexTest: LetterHome.class
	echo Main-class: LetterHome > Manifest
	jar cvfm LetterHome Manifest LetterHome.class
	rm Manifest
	chmod u+x LetterHome

ComplexTest.class: LetterHome.java 
	javac -Xlint LetterHome.java

Complex.class: LetterHome.java
	javac -Xlint LetterHome.java

clean:
	rm -f LetterHome.class

spotless: clean
	rm -f LetterHome

submit:
	submit cmps011-pt.w16 lab5 LetterHome.java Makefile
