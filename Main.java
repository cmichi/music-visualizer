//package main;

import processing.core.PApplet;
import javax.media.opengl.GL;
//import javax.media.opengl.GL2;

//import com.sun.opengl.util.GLUT;

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

	int BLUE = color(255,0,0);
	int YELLOW = color(255, 255, 0);
	int GREEN = color(255,0,0);
	int RED = color(255, 0, 0);
	int BLACK = 0;
	int WHITE = 255;
	//int BG = color(0x091720);

	int BG = color(9, 23, 32); 		// #091720
	int COL1 = color(173, 218, 237);	// #addaed
	int COL2 = color(9, 111, 111);		// #096f6f
	int COL3 = color(122, 255, 255);	// #7affff

	private Ring ring1;
	private Ring ring2;
	private Ring ring3;
	private Ringfoo ringfoo;
	 
	 Minim minim;
	 AudioInput in;
	 BeatDetect beat;

	 float eRadius2;
	 //bl BeatListener;
	
	public void setup() {
		frameRate(30);
		//size(700, 700, OPENGL);
		//size(displayWidth, displayHeight, OPENGL);
		size(displayWidth, displayHeight, OPENGL);
		  //if (frame != null) {
		      //frame.setResizable(true);
			//}

		smooth();

		  minim = new Minim(this);
		  minim.debugOn();
		    
		   //in = minim.getLineIn(Minim.STEREO, 2048);
		   in = minim.getLineIn(Minim.STEREO, 314);
		   //in = minim.getLineIn();
		    beat = new BeatDetect();
		    beat.setSensitivity(50);
		    //bl = new BeatListener(beat, in)
		      
			ellipseMode(RADIUS);
			  eRadius2 = 20;

		ring1 = new Ring(this, width / 2, height / 2, 280, COL1);
		ring2 = new Ring(this, width / 2, height / 2, 280, COL2);
		ring3 = new Ring(this, width / 2, height / 2, 280, COL3);
		ringfoo = new Ringfoo(this, width / 2, height / 2, 280, COL3);
	}

	float eRadius = 1.8f;
	int COL;
	public void draw() {
		background(BG);

		eRadius = (eRadius + 0.1f) % 4.0f;
		float step = TWO_PI / 32.0f;
		float rotation = (radians(frameCount % 360));
		
		/*
		ring1.draw(eRadius, step, rotation);
		ring2.draw(eRadius, step, 0);
		ring3.draw(eRadius, step, 0.2f);
		*/

		
		if (COL == COL1)
			COL = COL1;
		else
			COL = COL1;
		ringfoo.draw(in.mix, eRadius, COL2);
		//ringfoo.draw(in.right, eRadius, COL2);

		/*
		for(int i = 0; i < in.bufferSize() - 1; i++) {
			line(i, 50 + in.left.get(i)*50, i+1, 50 + in.left.get(i+1)*50 );
			line(i, 150 + in.right.get(i)*50, i+1, 150 + in.right.get(i+1)*50 );
		{
		*/


/*
		 for(int i = 0; i < in.bufferSize() - 1; i++)
		   {
		       line( i, 50 + in.left.get(i)*50, i+1, 50 +
		       in.left.get(i+1)*50 );
			   line( i, 150 + in.right.get(i)*50, i+1, 150 +
			   in.right.get(i+1)*50 );
			     }

*/



			     beat.detect(in.mix);
			       float a = map(eRadius2, 20, 80, 60, 255);
				 //fill(60, 255, 0, a);
				 //fill(COL2);
				 noFill();
				 stroke(COL2);
				   //if ( beat.isOnset() ) eRadius2 = 80;
				   if ( beat.isOnset() ) eRadius2 = 80;
				     ellipse(width/2, height/2, eRadius2, eRadius2);
				       eRadius2 *= 0.95;
					 if ( eRadius2 < 20 ) eRadius2 = 20;
	}

	private void addPoint(float x, float y) {
		bezierVertex(x - 30, y + 30, x - 40, y - 40, x, y);
	}

	public static void main(String args[]) {
		//PApplet.main(new String[] { "--present", "--full-screen", "Main" });
		PApplet.main(new String[] { "Main" });
		//PApplet.main(new String[] { "--present", "Main" });
	}

	@Override 
	public boolean sketchFullScreen() {
		return true;
	}

	public void stop()
	{
	  // always close Minim audio classes when you are done with them
	    in.close();
	      minim.stop();
		
		  super.stop();
		  }

}
