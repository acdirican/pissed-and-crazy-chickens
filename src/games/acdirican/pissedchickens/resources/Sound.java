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
public enum Sound {
	ROOSTER1("rooster1"),
	ROOSTER2("rooster2"),
	ROOSTER3("rooster3"),
	CHIKEN1("chiken1"),
	CHIKEN2("chiken2"),
	CHIK("chik"),
	BOMB("bomb"), 
	FALL("fall"), 
	APPLAUSE("applause");

	private String name;

	Sound(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getFilePath() {
		return Game.RESOURCES  + name + ".wav";
	}


	
}
