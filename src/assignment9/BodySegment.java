package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.x = x;
		this.y = y;
		this.size = size;
		color = StdDraw.GREEN;
		//See ColorUtils for some color options (or choose your own)
	}
	public BodySegment(double x, double y, double size, Color color) {
		//FIXME
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		//See ColorUtils for some color options (or choose your own)
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double dX) {
		this.x = x + dX;
	}
	public void setY(double dY) {
		this.y = y + dY;
	}
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, size);
	}
	
}
