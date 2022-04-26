package games.acdirican.pissedchickens.resources;

import games.acdirican.pissedchickens.Game;

/**
 * Pissed and crazy chickens against Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public enum Chicken {
	CRAZY("crazy", Sound.ROOSTER2),
	CUTEY("cutey", Sound.CHICK),
	EGGY("EGGY", Sound.CHICK),
	FEARY("feary", Sound.ROOSTER3),
	HUMPY("humpy", Sound.CHICKEN1),
	POINTY("pointy", Sound.ROOSTER1),
	SMARTY("smarty", Sound.CHICK),
	STRONGY("strongy", Sound.CHICKEN2);
	

	private String name;
	private String imageName;
	private Sound voice;
	
	Chicken(String name, Sound voice) {
		this.name =  name;
		this.imageName = name + ".png";
		this.voice = voice;
	}
	
	Chicken(String name, String imageName) {
		this.name =  name;
		this.imageName = imageName;
	}

	public String imageName() {
		return Game.RESOURCES + imageName;
	}

	public static Chicken random() {
		int i = (int) (Math.random() * Chicken.values().length);
		return Chicken.values()[i];
	}
	
	public Sound voice() {
		return this.voice;
	}
}
