package games.acdirican.pissedchickens.entities;

import java.awt.Color;

import stddraw.StdDraw;

/**
 * Pissed and crazy chickens against Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public class Point extends GameObject{

	public Point(double x, double y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hit(double x, double y) {
		return x==this.x && y==this.y;
	}
	
	public void draw() {
		draw(false);
	}
	
	@Override
	public void draw(boolean withImage) {
		
		if (!image.isEmpty() && withImage) {
			StdDraw.picture(x, y, image, 1, 1);
		}
		else {
			StdDraw.point(x, y);
		}
		
	}


}
