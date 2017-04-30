package com.kaylieweable.breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;

public class Brick extends GameObject{

	private int width = 90, height = 15;
	
	public Brick(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void move() {
		
		//Collision with the ball
	}

	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		//(int) changes the value from a float to an int
		g.fillRect((int)x, (int)y, width, height);
	}

	public Rectangle getBounds() {
		return null;
	}

	public Rectangle getBoundsTop() {
		return null;
	}

	public Rectangle getBoundsBottom() {
		return null;
	}

	public Rectangle getBoundsLeft() {
		return null;
	}

	public Rectangle getBoundsRight() {
		return null;
	}

}
