package games.acdirican.angrychickens.entities;

/**
 * Pissed and crazy chickens against Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public interface IGameObject {
	void draw(boolean withImage);
	boolean hit(double x, double y);
	boolean isTarget();
}
