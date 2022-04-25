package games.acdirican.angrychickens;

/**
 * Pissed and crazy chickens against Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public class Utils {
	static public double geoDis(double x1, double y1, double x2, double y2) {
		return Math.sqrt(
				Math.pow(x1-x2,2)+
				Math.pow(y1-y2, 2)	
				);
	}
}
