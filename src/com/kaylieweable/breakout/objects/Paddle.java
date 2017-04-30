package com.kaylieweable.breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;

public class Paddle extends GameObject{

	private int width = 62, height = 10;
	
	public Paddle(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void move() {
		x += velX;
		
		//determine if the paddle reaches the left or right bounds
		
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
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
