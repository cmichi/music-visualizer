package src;

import processing.core.*;
import processing.opengl.*;
import javax.media.opengl.GL;

import ddf.minim.*;
import ddf.minim.analysis.*;

public class Main extends PApplet {
	private static final long serialVersionUID = 1L;

	private Minim minim;
	private AudioInput in;
	private BeatDetect beatSound;
	private BeatDetect beatFreq;

	private final int BG = color(9, 23, 32); 	// #091720
	private final int COL1 = color(173, 218, 237);	// #addaed
	private final int COL2 = color(9, 111, 111);	// #096f6f
	private final int COL3 = color(122, 255, 255);	// #7affff

	private Ring ring;
	private float beatRadius;
	
	public void setup() {
		frameRate(25);
		size(displayWidth, displayHeight);

		smooth();

		minim = new Minim(this);
		minim.debugOn();
		    
		in = minim.getLineIn(Minim.STEREO);
		beatSound = new BeatDetect();
		beatSound.detectMode(BeatDetect.SOUND_ENERGY);

		beatFreq = new BeatDetect();
		beatFreq.detectMode(BeatDetect.FREQ_ENERGY);

		ring = new Ring(this, width/2, height/2, 280);
	}

	public void draw() {
		background(BG);

		ring.draw(in.mix, COL2);

		/* separate ring for right/left channel? */
		//ring.draw(in.left, COL2);
		//ring.draw(in.right, COL2);

		drawBeat();
	}

	public void drawBeat() {
		noFill();
		stroke(COL2);
		ellipseMode(RADIUS);

		beatSound.detect(in.mix);
		beatFreq.detect(in.mix);
		if (beatSound.isOnset() || beatFreq.isKick() || beatFreq.isSnare() || beatFreq.isHat()) 
			beatRadius = height*0.11f;

		ellipse(width/2, height/2, beatRadius, beatRadius);
		beatRadius *= 0.95;

		if (beatRadius < height*0.08) beatRadius = height*0.08f;
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

	public static void main(String args[]) {
		PApplet.main(new String[] { "src.Main" });
		/* PApplet.main(new String[] { "--present", "src.Main" }); */
	}
}
