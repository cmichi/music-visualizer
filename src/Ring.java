package src;

import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.Minim;
import ddf.minim.*;

public class Ring {
	private int x;
	private int y;
	private int radius;
	private PApplet p;

	public Ring(PApplet _main, int _x, int _y, int _radius) {
		this.x = _x;
		this.y = _y;
		this.radius = _radius;
		this.p = _main;
	}
	
	public void draw(AudioBuffer stuff, int color) {
		p.stroke(color);
		p.noFill();
		
		p.pushMatrix();
		p.translate(x, y);
		
		p.beginShape();

		int numPoints = stuff.size();
		float angle = p.TWO_PI / (float) numPoints;

		for(int i = 0; i < numPoints; i++) {
			float radius_ = radius + (stuff.get(i) * 50);
			float x = radius_ * p.sin(angle*i);
			float y = radius_ * p.cos(angle*i);

			p.curveVertex(x, y);
		} 

		p.endShape(p.CLOSE);
		p.popMatrix();		
	}
}
