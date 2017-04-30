package com.kaylieweable.breakout.objects;

import java.awt.Graphics;
import java.util.LinkedList;


//import GameObject
import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;

public class Handler {

	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	//temp object that refers to one of the object classes within linked list
	private GameObject tempObject;
	
	public void move(){
		//loops through each object list and moves each object using the object's move method
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			tempObject.move();
		}
	}
	
	public void render(Graphics g){
		//loops through each object list and renders graphics
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		//reference linked list - add objects
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		//reference linked list - remove objects
		this.object.remove(object);
	}
	
	public void createLevel(){
		
		int xpos = 50;
		
		for(int x = 0; x < 7; x++){
			addObject(new Brick(xpos, 100, ObjectId.Brick));
		}
	}
}
