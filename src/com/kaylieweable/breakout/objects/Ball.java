package com.kaylieweable.breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;
import com.kaylieweable.breakout.window.Board;
import com.kaylieweable.breakout.window.Handler;

public class Ball extends GameObject{

	private int width = 20, height = 20;
	private GameObject paddleTemp;
	Handler handler;
	public Ball(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Paddle){
				paddleTemp = tempObject;
			}
		}

	}

	public void move() {
		
		x += velX;
		y += velY;
		
		//collision against wall
		//sends the ball in the right direction
		if(x <= 0){
			velX = 8;
		}
		//sends the ball in the left direction
		//a little before 800 so none of our ball is cut off
		if(x >= 790){
			velX = -8;
		}
		//y increases from top to bottom so this sends ball toward bottom after hits top
		if(y <= 0){
			velY = 8;
		}
		
		//collision against the brick or paddle
		
		//falling below the paddle or board
		resetBall();
	}
	
	public void resetBall(){
		if(y > Board.HEIGHT){
			velX = 0;
			velY = 0;
			//sets ball in the center of the paddle when game resets
			x = paddleTemp.getX() + 20;
			y = paddleTemp.getY() - 20;
		}
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
