package games.acdirican.angrychickens.entities;
import java.awt.Color;

/**
 * Pissed and crazy chickens against Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public abstract class GameObject implements IGameObject{
	
	protected double x,y;
	protected Color color;
	protected boolean target;
	protected String image;
	/**
	 * 
	 * @param x   		coordinate in x axis 
	 * @param y 		coordinate in y axis
	 * @param color		object color, 
	 * @param target	is target or decor?
	 */
	public GameObject(double x, double y, Color color, boolean target) {
		this(x,y,color,target,"");
	}
	
	public GameObject(double x, double y, Color color) {
		this(x,y,color,false,"");
	}
	

	
	public GameObject(double x, double y, Color color, boolean target, String image) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.target = target;
		this.image= image;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 
	 * @return true is the object is a target.
	 */
	
	@Override
	public boolean isTarget() {
		return target;
	}

	public void setTarget(boolean target) {
		this.target = target;
	}
	


}
