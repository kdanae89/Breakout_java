package com.kaylieweable.breakout.window;

import java.awt.Graphics;
import java.util.LinkedList;




//import GameObject
import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.ObjectId;
import com.kaylieweable.breakout.framework.State;
import com.kaylieweable.breakout.objects.Brick;

public class Handler {

	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	//temp object that refers to one of the object classes within linked list
	private GameObject tempObject;
	private State state;
	//state constructor - start game off dead
	public Handler(){
		state = State.dead;
	}
	//state setter
	public void setState(State state){
		this.state = state;
	}
	//state getter
	public State getState(){
		return state;
	}
	
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
	//create our level(1) - brick design
	public void createLevel(){
		//add object to linked list/create
		int xpos = 50;
		//first row of bricks
		for(int x = 0; x < 7; x++){
			addObject(new Brick(xpos, 100, this, ObjectId.Brick));
			//move bricks over so they don't overlap
			xpos+= 100;
		}
		//second row
		xpos = 50;
		for(int x = 0; x < 7; x++){
			addObject(new Brick(xpos, 120, this, ObjectId.Brick));
			//move bricks over so they don't overlap
			xpos+= 100;
		}
		//third row
		xpos = 50;
		for(int x = 0; x < 7; x++){
			addObject(new Brick(xpos, 140, this, ObjectId.Brick));
			//move bricks over so they don't overlap
			xpos+= 100;
		}
	}
}
