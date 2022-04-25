package games.acdirican.angrychickens.entities;

import java.awt.Color;

import games.acdirican.angrychickens.resources.Chicken;
import games.acdirican.angrychickens.resources.Sound;

/**
 * Pissed chikens againts Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public class AngryChicken extends CirclerObject{
	private final Chicken type;
	public AngryChicken(double x, double y, Color color, int radius, Chicken type) {
		super(x, y, color, radius, false, type.imageName());
		this.type =type;
	}
	public Chicken getType() {
		return type;
	}
	public String voicePath() {
		return type.voice().getFilePath();
	}
	
	public Sound getVoice() {
		return type.voice();
	}
	
	
}
