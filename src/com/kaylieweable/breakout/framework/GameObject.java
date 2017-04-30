package com.kaylieweable.breakout.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
//game object that game pieces will extend from
//abstract class is a class you can't create an object from - can use as template
public abstract class GameObject {
	//protected - access identifier-any class that extends game object class can use
	//coordinates of objects
	protected float x,y;
	//determines speed upon which objects move
	protected float velX = 0, velY = 0;
	protected ObjectId id;
	
	public GameObject(float x, float y, ObjectId id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//providing nuances to each class that extends GameObject
	public abstract void move();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract Rectangle getBoundsTop();
	public abstract Rectangle getBoundsBottom();
	public abstract Rectangle getBoundsLeft();
	public abstract Rectangle getBoundsRight();
	
	//getters and setters - wont make private vars public
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setVelX(float velX){
		this.velX = velX;
	}
	
	public void setVelY(float velY){
		this.velY = velY;
	}
	
	public float getVelX(){
		return velX;
	}
	
	public float getVelY(){
		return velY;
	}
	
	public ObjectId getId(){
		return id;
	}
}
