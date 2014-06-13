default:
	make compile
	make run

CP = "/usr/share/processing/core/library/jogl-all.jar:/usr/share/processing/core/library/gluegen-rt.jar:/usr/share/processing/core/library/core.jar:./minim/library/minim.jar:./minim/library/jsminim.jar:."
#CP = "/usr/share/processing/core/library/jogl-all-natives-linux-i586.jar:/usr/share/processing/core/library/gluegen-rt-natives-linux-i586.jar:/usr/share/processing/core/library/core.jar:./minim/library/minim.jar:."


compile:
	javac -cp $(CP) Main.java Ring.java Ringfoo.java

run:
	java -cp $(CP) Main 
