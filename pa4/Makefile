# Makefile for lab5
# Matthew Tan
# mxtan
# pa4
# Creates the Makefile for pa4
# ------------------------------------------------

Roots: Roots.class
	echo Main-class: Roots > Manifest
	jar cvfm Roots Manifest Roots.class
	rm Manifest
	chmod u+x Roots

Roots.class: Roots.java 
	javac -Xlint Roots.java

clean:
	rm -f Roots.class

spotless: clean
	rm -f Roots

submit:
	submit cmps011-pt.w16 pa4 Roots.java Makefile
