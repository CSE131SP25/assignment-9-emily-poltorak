package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	private Color color;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		double tempx = (double)(4 * (int)(Math.random() * 24 + 1) - 2) / 100;
		double tempy = (double)(4 * (int)(Math.random() * 24 + 1) - 2) / 100;
		while(tempx < 0.04 && tempx > 0.96) {
			tempx = Math.random();
		}
		while(tempy < 0.04 && tempy > 0.96) {
			tempy = Math.random();
		}
		x = tempx;
		y = tempy;
		this.color = ColorUtils.solidColor();
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
}
