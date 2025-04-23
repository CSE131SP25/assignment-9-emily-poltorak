package assignment9;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 2;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE, StdDraw.BLACK));
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	
	//The snake moves by adding a new head segment in the direction of movement 
	//and removing the last segment 
	//so it "moves" forward visually
	public void move() {
		segments.addFirst(new BodySegment(segments.get(0).getX() + deltaX, segments.get(0).getY() + deltaY, SEGMENT_SIZE));
		segments.removeLast();
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(int i = 0; i < segments.size(); i++) {
			segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	
	//If the snake's head is close enough to the food, 
	//a new segment is added at the tail end 
	//in the opposite direction of movement
	public boolean eatFood(Food f) {
		if(distance(f.getX(), f.getY(), segments.get(0).getX(), segments.get(0).getY()) < 0.02) {
			segments.add(new BodySegment(segments.getLast().getX() - deltaX, segments.getLast().getY() - deltaY, SEGMENT_SIZE));
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//if the snake leaves the visible area the loop exits and the game ends
		if((segments.get(0).getX() >= 0 && segments.get(0).getX() <= 1) && (segments.get(0).getY() >= 0 && segments.get(0).getY() <= 1)) {
			return true;
		}
		return false;
	}
	public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
