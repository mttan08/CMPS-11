# Makefile for pa5
# Matthew Tan
# mxtan
# pa5
# Creates the Makefile for pa5
# ------------------------------------------------

Queens: Queens.class
	echo Main-class: Queens > Manifest
	jar cvfm Queens Manifest Queens.class
	rm Manifest
	chmod u+x Queens

Queens.class: Queens.java 
	javac -Xlint Queens.java

clean:
	rm -f Queens.class

spotless: clean
	rm -f Queens

submit:
	submit cmps011-pt.w16 pa5 Queens.java Makefile
