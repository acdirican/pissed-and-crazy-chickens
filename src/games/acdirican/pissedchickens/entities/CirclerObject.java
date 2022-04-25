package games.acdirican.pissedchickens.entities;

import java.awt.Color;

import games.acdirican.pissedchickens.Utils;
import stddraw.StdDraw;

/**
 * Pissed chikens againts Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public class CirclerObject extends GameObject{
	protected double radius;

	public CirclerObject(int x, int y, Color color, double radius, boolean target) {
		super(x, y, color, target);
		this.radius = radius;
	}

	public CirclerObject(double x, double y, Color color, double radius) {
		super(x, y, color);
		this.radius = radius;
	}
		
	public CirclerObject(double x, double y, Color color, double radius, boolean target, String image) {
		super(x, y, color, target, image);
		this.radius = radius;
	}
	
	public CirclerObject(double x, double y, Color color, double radius,  String image) {
		super(x, y, color, false, image);
		this.radius = radius;
	}
	
	@Override
	public void draw(boolean withImage) {
		if (!image.isEmpty() && withImage) {
			StdDraw.picture(x, y, image, radius*2, radius*2);
		}
		else {
			Color c = StdDraw.getPenColor();
			StdDraw.setPenColor(color);
			StdDraw.filledCircle(x, y, radius);
			StdDraw.setPenColor(c);
		}
	}

	@Override
	public boolean hit(double x, double y) {
		if(Utils.geoDis(x, y, this.x, this.y)<=radius) {
			System.out.println("HIT!!!");
			return true;
		}
		
		return false;
		
	}
	
	
	
	
	
}
