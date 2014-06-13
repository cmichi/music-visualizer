#CP = "/usr/share/processing/core/library/jogl-all.jar:/usr/share/processing/core/library/gluegen-rt.jar:/usr/share/processing/core/library/core.jar:./lib/minim.jar:./lib/jsminim.jar:./src/:."
CP = "./lib/processing/core/library/jogl-all.jar:./lib/processing/core/library/gluegen-rt.jar:./lib/processing/core/library/core.jar:./lib/minim.jar:./lib/jsminim.jar:./src/:."

default:
	make compile
	make run

compile:
	javac -cp $(CP) src/Main.java src/Ringfoo.java

run:
	java -cp $(CP) src/Main

jar:
	jar cvfm visualizer.jar Manifest.txt src/*.class ./lib/ 

runjar:
	java -jar visualizer.jar
