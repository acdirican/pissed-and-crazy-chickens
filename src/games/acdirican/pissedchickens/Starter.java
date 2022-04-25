package games.acdirican.pissedchickens;
import stddraw.StdDraw;
  
//javadoc

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import games.acdirican.pissedchickens.entities.AngryChicken;
import games.acdirican.pissedchickens.entities.CirclerObject;
import games.acdirican.pissedchickens.entities.IGameObject;
import games.acdirican.pissedchickens.entities.RectObject;

/**
 * Pissed and crazy chickens against Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public class Starter {
	public static void main(String[] args) {
	
		Game game =  new Game(1280, 720);
		game.init();

	}
}
