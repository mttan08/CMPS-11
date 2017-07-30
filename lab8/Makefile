# Makefile for lab8
# Matthew Tan
# mxtan
# lab8
# Creates the Makefile for lab8
# ------------------------------------------------
GCD: GCD.o
	gcc -o GCD GCD.o

GCD.o: GCD.c
	gcc -c -std=c99 GCD.c

clean:
	rm -f GCD.o

spotless:
	rm -f GCD.o GCD

submit: Makefile GCD.c
	submit cmps011-pt.w16 lab8 Makefile GCD.c
