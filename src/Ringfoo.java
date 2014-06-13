package src;

import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.Minim;
import ddf.minim.*;

public class Ringfoo {

	private int x;
	private int y;
	private int r;
	private int col;
	private PApplet p;

	public Ringfoo(PApplet m, int x, int y, int r, int col) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.col = col;
		this.p = m;
	}
	
	public void draw(AudioBuffer stuff, float eRadius, int COL) {
		int scale = 280;
		
		p.stroke(COL);
		p.noFill();
		
		p.pushMatrix();
		p.translate(x, y);
		
		p.beginShape();
		int step = 1;

		float radius = 280;
		int numPoints = stuff.size();
		float angle = p.TWO_PI / (float)numPoints;
		angle = p.TWO_PI / 314.0f;

		for(int i = 0; i < numPoints; i++) {
			// point(radius * sin(angle*i), radius * cos(angle*i));
			float radius_ = radius + stuff.get(i)*50;
			float x = radius_ * p.sin(angle*i);
			float y = radius_ * p.cos(angle*i);
			p.curveVertex(x, y);
		} 

		p.endShape(p.CLOSE);
		p.popMatrix();		
		
		/*
		p.curveVertex(0 + p.sin(p.TWO_PI) * scale, 0 + p.cos(p.TWO_PI) * scale);
		scale_ = 1.0f + p.abs(p.sin(eRadius / 10.0f)) * 0.6f;

		//for (j = 0.0f; j <= p.TWO_PI; j += step) {
		for (j = 0; j <= 255; j += step) {
			float foo = stuff.get(j);
			if (a % 2 == 0)
				p.curveVertex(0 + p.sin(foo) * scale * scale_, 0 + p.cos(foo) * scale
						* scale_);
			else
				p.curveVertex(0 + p.sin(foo) * scale, 0 + p.cos(foo) * scale);
			a++;
		}
		
		p.curveVertex(0 + p.sin(j) * scale * scale_, 0 + p.cos(j) * scale * scale_);
		p.curveVertex(0 + p.sin(j) * scale * scale_, 0 + p.cos(j) * scale * scale_);
		*/
	}

}
