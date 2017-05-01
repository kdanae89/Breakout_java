package com.kaylieweable.breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;
import com.kaylieweable.breakout.window.Handler;

public class Paddle extends GameObject{

	private int width = 62, height = 10;
	Handler handler;
	public Paddle(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void move() {
		x += velX;
		
		//determine if the paddle reaches the left or right bounds
		if(x <= 0){
			velX = 0;
			x = 0;
		}
		//taking into account paddle width for edge touch on right bound
		else if(x >= 738){
			velX = 0;
			x = 738;
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect((int)x, (int)y, width, height);
		//sets rectangles around object for collision visualization
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}


	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}

	public Rectangle getBoundsBottom() {
		return null;
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y, (int)15, (int)height);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x + width -15), (int)y, (int)15, (int)height);
	}

}
