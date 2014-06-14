package src;

import processing.core.PApplet;
import ddf.minim.*;
import java.lang.Math;

public class Ring {
	private int x;
	private int y;
	private float radius;
	private PApplet p;

	public Ring(PApplet _main, int _x, int _y, float _radius) {
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
			float radius_ = radius + (stuff.get(i) * 50.0f);
			//float radius_ = radius + (float)(Math.log(stuff.get(i)) * 50.0f);
			float x = radius_ * p.sin(angle*i);
			float y = radius_ * p.cos(angle*i);

			p.curveVertex(x, y);
		} 

		p.endShape(p.CLOSE);
		p.popMatrix();		
	}
}
