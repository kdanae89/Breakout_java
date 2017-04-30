package com.kaylieweable.breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;

public class Ball extends GameObject{

	private int width = 20, height = 20;
	public Ball(float x, float y, ObjectId id) {
		super(x, y, id);

	}

	public void move() {
		
		x += velX;
		y += velY;
		
		//collision against wall
		
		//collision against the brick or paddle
		
		//falling below the paddle or board
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, width, height);
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
