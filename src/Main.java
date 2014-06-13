package src;

import processing.core.PApplet;
import javax.media.opengl.GL;

import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;
import ddf.minim.analysis.*;
import ddf.minim.*;
import processing.core.*;
import processing.opengl.*;

public class Main extends PApplet {
	private static final long serialVersionUID = 1L;

	int BG = color(9, 23, 32); 		// #091720
	int COL1 = color(173, 218, 237);	// #addaed
	int COL2 = color(9, 111, 111);		// #096f6f
	int COL3 = color(122, 255, 255);	// #7affff

	private Ring ring;
	 
	Minim minim;
	AudioInput in;
	BeatDetect beat;

	float eRadius2;
	float eRadius = 1.8f;
	int COL;
	
	public void setup() {
		frameRate(30);
		size(displayWidth, displayHeight, OPENGL);

		smooth();

		minim = new Minim(this);
		minim.debugOn();
		    
		in = minim.getLineIn(Minim.STEREO, 314);
		beat = new BeatDetect();
		beat.setSensitivity(50);
		      
		ellipseMode(RADIUS);
		eRadius2 = 20;

		ring = new Ring(this, width / 2, height / 2, 280);
	}

	public void draw() {
		background(BG);

		eRadius = (eRadius + 0.1f) % 4.0f;
		float step = TWO_PI / 32.0f;
		float rotation = (radians(frameCount % 360));
		
		ring.draw(in.mix, COL2);

		/* separate ring for right/left channel? */
		//ring.draw(in.left, eRadius, COL2);
		//ring.draw(in.right, eRadius, COL2);

		beat.detect(in.mix);
		float a = map(eRadius2, 20, 80, 60, 255);
		noFill();
		stroke(COL2);
		if ( beat.isOnset() ) eRadius2 = 80;
		ellipse(width/2, height/2, eRadius2, eRadius2);
		eRadius2 *= 0.95;
		if ( eRadius2 < 20 ) eRadius2 = 20;
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "src.Main" });
		/* PApplet.main(new String[] { "--present", "src.Main" }); */
	}

	public void stop() {
		/* close Minim audio classes when done with them */
		in.close();
		minim.stop();
		super.stop();
	}

	@Override 
	public boolean sketchFullScreen() {
		return true;
	}
}
