CP = .
CP := ${CP}:./lib/processing/core/library/jogl-all.jar
CP := ${CP}:./lib/processing/core/library/gluegen-rt.jar
CP := ${CP}:./lib/processing/core/library/core.jar
CP := ${CP}:./lib/minim.jar
CP := ${CP}:./lib/jsminim.jar

default:
	make compile
	make run

compile:
	javac -cp $(CP) src/Main.java src/Ring.java

clean:
	rm ./src/*class

run:
	java -cp $(CP) src/Main

jar:
	jar cvfm ./visualizer.jar ./Manifest.txt ./src/*.class ./lib/ 

runjar:
	java -jar ./visualizer.jar
