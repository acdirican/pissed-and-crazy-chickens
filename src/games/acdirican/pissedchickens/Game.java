package games.acdirican.pissedchickens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import games.acdirican.pissedchickens.entities.AngryChicken;
import games.acdirican.pissedchickens.entities.CirclerObject;
import games.acdirican.pissedchickens.entities.IGameObject;
import games.acdirican.pissedchickens.entities.Point;
import games.acdirican.pissedchickens.entities.RectObject;
import games.acdirican.pissedchickens.resources.Chicken;
import games.acdirican.pissedchickens.resources.Fox;
import games.acdirican.pissedchickens.resources.Sound;
import games.acdirican.pissedchickens.utils.SoundPlayer;
import games.acdirican.pissedchickens.utils.Utils;
import stddraw.StdDraw;

/**
 * Pissed and crazy chickens against Foxes. :-)
 * 
 * @author Ahmet Cengizhan Dirican
 * @version 1.0
 * April 2022
 *
 */
public class Game {

	/*
	 * Some image resources
	 */
	public static final String RESOURCES = "/";
	private static final String START_IMAGE = RESOURCES + "poster.jpg";
	private static String BACK_IMAGE =RESOURCES + "background1.png" ;
	private static String COLUMN = RESOURCES  + "column1.png";
	private static String BACK_MUSIC = RESOURCES  + "backmusic.wav";
	
	/*
	 * Frame with and height
	 */
	private int width;
	private int height;
	
	/*
	 * Shoot angle and velocity
	 */
	private double angle;
	private double velocity;
	
	/*
	 * Shooting chiken
	 */
	private AngryChicken chiken;
	
	/*
	 *All the object on the playground 
	 */
	private ArrayList<IGameObject> objects;
	
	/**
	 * Chiken trajectory
	 */
	private List<Point> trajectory ;
	
	/*
	 * FOX number to eliminate.
	 */
	private int numberOfFoxes;
	
	/**
	 * Draw the shooting trajectýry or not
	 */
	private boolean drawTrajectory = true;
	
	/**
	 * 
	 */
	private SoundPlayer player =  new SoundPlayer();
	
	public Game(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.angle=Math.PI/4;
		this.velocity=160;
		
	}
	
	private ArrayList<IGameObject> createObjectsAndCharacters() {
		objects = new  ArrayList<IGameObject>();
		
		int x =Utils.randomBetween(300,400);
		objects.add(new RectObject(x,200, StdDraw.CYAN,40,150, COLUMN));
		objects.add(new CirclerObject(x, 302, StdDraw.RED, 30, true, Fox.BOXY.imageName()));
		
		x =Utils.randomBetween(450,600);
		objects.add(new RectObject(x, 60, StdDraw.BLACK,40,80,COLUMN));
		objects.add(new CirclerObject(x, 120, StdDraw.RED, 40, true, Fox.TOXY.imageName()));
		
		x =Utils.randomBetween(650,750);
		objects.add(new RectObject(x,150,StdDraw.GREEN,100,300, COLUMN));
		objects.add(new CirclerObject(x,335,StdDraw.RED,40, true, Fox.FOXY.imageName()));
		
		x =Utils.randomBetween(800,950);
		objects.add(new RectObject(x,370,StdDraw.BLACK,80,350, COLUMN));
		objects.add(new CirclerObject(x, 575, StdDraw.RED, 40, true, Fox.SOXY.imageName()));
		
		x =Utils.randomBetween(1050,1200);
		objects.add(new RectObject(x,100,StdDraw.GREEN,100,200, COLUMN));
		objects.add(new CirclerObject(x, 237, StdDraw.RED, 40, true, Fox.BOXY.imageName()));
		
		return objects;
	}

	private ArrayList<IGameObject> createObjectsAndCharacters2() {
		objects = new  ArrayList<IGameObject>();
		
		for (int i = 0; i < numberOfFoxes; i++) {
			int bx = 200 + Utils.RND.nextInt(width-50);
			int by = Utils.RND.nextInt(250);
			int bw = 30 + Utils.RND.nextInt(70);
			int bh = 30 + Utils.RND.nextInt(400);
			objects.add(new RectObject(bx,by, StdDraw.CYAN,bw,bh, COLUMN));
			//objects.add(new CirclerObject(400, 452, StdDraw.RED, 30, true, Fox.random().imageName()));
		}
		

		
		return objects;
	}
	
	public void init() {
		StdDraw.setCanvasSize(1000, 700);
		StdDraw.setXscale(0, 1000);
		StdDraw.setYscale(0, 700);
		StdDraw.enableDoubleBuffering();
	
		StdDraw.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		StdDraw.setPenColor(Color.WHITE);
		
		StdDraw.picture(500, 350, START_IMAGE, 1000, 700);
		StdDraw.show();
		while (StdDraw.isKeyPressed(KeyEvent.VK_Q) == false) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
				startGame();
				break;
			}
		}
	}
	
	public void startGame() {
		setupFrame();
		createObjectsAndCharacters();
		numberOfFoxes = 5;
		playAudio(Sound.ROOSTER1);
		play();
		gameOver();
	}

	private void gameOver() {
		drawBackground();
		replaceObjects();
		
		StdDraw.text(width/2, height/2, "Congratulations. You win the game. Press S to restart.");
		StdDraw.show();
		playAudio(Sound.APPLAUSE);
		while (StdDraw.isKeyPressed(KeyEvent.VK_Q) == false) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
				startGame();
				break;
			}
		}
	}

	private void setupFrame() {
		// initialize the canvas
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.enableDoubleBuffering();
		StdDraw.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		
	}

	private void play() {

		double x0 = 0, y0 = 0, x = x0, y = y0, vx = 0, vy = 0, t = 0;

		chiken = new AngryChicken(x0, y0, Color.MAGENTA, 50, Chicken.random());



		double bx, by;

		while (StdDraw.isKeyPressed(KeyEvent.VK_Q) == false) {
			bx = x0 + Math.cos(angle) * velocity;
			by = y0 + Math.sin(angle) * velocity;
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_T)) {
				drawTrajectory = !drawTrajectory;
			}
			
			setShooter();
			drawScene(x0, y0, bx, by);
					
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				playAudio(chiken.getVoice());
				int hitCount = shoot(vx, vy, bx, by, x, y, t);
				if (hitCount != 0) {
					if (hitCount == -1 ) {
						playAudio(Sound.FALL);
					}
					fall();
				}
				numberOfFoxes -= hitCount;
				if (numberOfFoxes == 0) {
					break;
				}
				chiken = new AngryChicken(x0, y0, Color.MAGENTA, 50, Chicken.random());
			}
			StdDraw.show();
		}

	}

	private void drawScene(double x0, double y0, double bx, double by) {
		// clear the screen, draw the rectangle, and show it on the screen
		StdDraw.clear();
		drawBackground();
		drawShooter(x0, y0, bx, by);
		replaceObjects();

		trajectory = computeTrajectory(bx, by);
		
		if (drawTrajectory) {
			drawTrajectory();
		}

	}

	private void fall() {
		double y = chiken.getY();
		do {
			drawBackground();
			replaceObjects();

			y -= velocity/4;
			chiken.setY(y);
			chiken.draw(true);
			StdDraw.show();
		} while (y > 0);

	}

	@SuppressWarnings("deprecation")
	private void playAudio(Sound sound) {
		//StdAudio.play(voice.getFilePath());	
		new SoundPlayer().playSound(sound.getFilePath());
	}

	private void drawTrajectory() {
		StdDraw.setPenRadius(0.01);
		trajectory.forEach(Point::draw);
		
	}

	private void drawShooter(double x0, double y0, double bx,  double by) {
		chiken.setX(bx);
		chiken.setY(by);

		StdDraw.line(x0, y0, bx, by);
		chiken.draw(true);
		
	}

	private void setShooter() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
			velocity -= 3;
			if (velocity <= 0 ) {
				velocity = 3;
			}
		}

		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
			velocity += 3;
		}

		if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
			angle += 0.04;
			if (angle >= Math.PI/2-0.04) {
				angle = Math.PI/2  -0.04;
			}
		}

		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
			angle -= 0.04;
			if (angle <= 0.04) {
				angle = 0.04;
			}
		}
		
	}

	private void replaceObjects() {
		for (IGameObject gameObject : objects) {
			gameObject.draw(true);
		}
	}


	private int shoot(double vx, double vy, double bx, double by, double x, double y, double t) {

		int hitCount = 0;
		t = 0;
	
		for(Point p : trajectory){;
			StdDraw.clear();
			x = p.getX();
			y = p.getY();
			
			boolean hit = false;
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i).hit(x, y)) {
					if (objects.get(i).isTarget()) {
						playAudio(Sound.BOMB);
						objects.remove(i);
						return 1;
					}
					//block hit
					return -1;
				}
			}
			
			drawBackground();
			replaceObjects();

			chiken.setX(x);
			chiken.setY(y);
			chiken.draw(true);

			StdDraw.show();
		}
		
		return hitCount;
	}

	private void drawBackground() {
		StdDraw.picture(width/2, height/2, BACK_IMAGE, width, height);
	}

	private List<Point>  computeTrajectory(double bx, double by) {
		List<Point> trajectory =  new ArrayList<>();
		
		double xu, yu, vxu, vyu, tu = 0;
		do {
			tu += 0.2;
			vxu = Math.cos(angle) * velocity/2;
			vyu = Math.sin(angle) * velocity/2;
			xu = bx + vxu * tu;
			yu = by + vyu * tu - 0.5 * 9.8 * (tu * tu);
			trajectory.add(new Point(xu, yu,Color.WHITE));

		} while (yu > 0 && xu <= width);
		
		return trajectory;
	}
}
