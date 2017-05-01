package com.kaylieweable.breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;
import com.kaylieweable.breakout.window.Handler;

public class Brick extends GameObject{

	private int width = 90, height = 15;
	Handler handler;
	public Brick(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void move() {
		
		//Collision with the ball
		Collision();
	}
	
	private void Collision(){
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Ball){
				if(getBounds().intersects(tempObject.getBounds())){
					
					handler.removeObject(this);
				}
			}
		}
	}

	public void render(Graphics g) {
		
		g.setColor(Color.cyan);
		//(int) changes the value from a float to an int
		g.fillRect((int)x, (int)y, width, height);
		//sets rectangles around object for collision visualization
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.blue);
		g2d.draw(getBounds());
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
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
