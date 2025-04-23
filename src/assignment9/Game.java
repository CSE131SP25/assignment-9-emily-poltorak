package assignment9;

import java.awt.event.KeyEvent;
import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake s;
	private Food f;
	
	//The Game class is the controller
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		s = new Snake();
		f = new Food();
		//FIXME - construct new Snake and Food objects
	}
	
	
	public void play() {
		//The game continues as long as the snake's head is within bounds
		while (s.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			s.changeDirection(dir);
			s.move();
			//When the snake eats the food (returns true)
			//a new Food object is created
			//this triggers the constructor in Food.java to place the food at a random location
			if(s.eatFood(f)) {
				f = new Food();
			}
			updateDrawing();
			
			/*
			 * 1. checks the bounds and Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.5, "GAME OVER");
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		drawGrid();
		s.draw();
		f.draw();
		StdDraw.pause(45);
		StdDraw.show();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void drawGrid(){
		Color gray = new Color(0, 0, 0, 32);
		StdDraw.setPenColor(gray);
		for(double i = 0; i <= 1; i = i + 0.04) {
			StdDraw.line(i, 0, i, 1);
			StdDraw.line(0, i, 1, i);
		}
	}
	
	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		Game g = new Game();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.75, "WELCOME TO SNAKE!");
		StdDraw.text(0.5, 0.6, "PRESS SPACE BAR TO START, AND THEN WASD TO CONTROL!");
		StdDraw.show();
		while(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
			StdDraw.pause(20);
		}
		StdDraw.clear();
		g.play();
	}
}
