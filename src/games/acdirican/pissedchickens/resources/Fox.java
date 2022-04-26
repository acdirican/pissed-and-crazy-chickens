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
public enum Fox {
	BOXY("boxy"),
	FOXY("foxy"),
	SOXY("soxy"),
	TOXY("toxy");
	

	private String name;
	private String imageName;
	
	Fox(String name) {
		this.name =  name;
		this.imageName = name + ".png";
	}
	
	Fox(String name, String imageName) {
		this.name =  name;
		this.imageName = imageName;
	}

	public String imageName() {
		return Game.RESOURCES  + imageName;
	}
	
	public static Fox random() {
		int i = (int) (Math.random() * Fox.values().length);
		return Fox.values()[i];
	}
}
