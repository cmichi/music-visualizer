CP = "/usr/share/processing/core/library/jogl-all.jar:/usr/share/processing/core/library/gluegen-rt.jar:/usr/share/processing/core/library/core.jar:./lib/minim.jar:./lib/jsminim.jar:."

default:
	make compile
	make run

compile:
	javac -cp $(CP) Main.java Ring.java Ringfoo.java

run:
	java -cp $(CP) Main 
