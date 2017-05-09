package com.kaylieweable.breakout.window;

import java.awt.Graphics;
import java.util.LinkedList;





//import GameObject
import com.kaylieweable.breakout.framework.GameObject;
import com.kaylieweable.breakout.framework.Level;
import com.kaylieweable.breakout.framework.ObjectId;
import com.kaylieweable.breakout.framework.State;
import com.kaylieweable.breakout.objects.Brick;

public class Handler {

	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	//temp object that refers to one of the object classes within linked list
	private GameObject tempObject;
	private State state;
	private Level level;
	//state constructor - start game off dead
	public Handler(){
		state = State.dead;
		level = Level.menu;
	}
	//state setter
	public void setState(State state){
		this.state = state;
	}
	//state getter
	public State getState(){
		return state;
	}
	//level setter
	public void setLevel(Level level){
		this.level = level;
	}
	//level getter
	public Level getLevel(){
		return level;
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
	
	public void createLevel2(){
		
		int xpos = 50;
		int ypos = 100;
		//creates first rows of bricks
		for(int x = 0; x < 7; x++){
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			//move bricks over so they don't overlap
			xpos+= 100;
		}
		
		xpos = 50;
		ypos = 120;
		//creates second row of bricks
		for(int x = 0; x < 10; x++){
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			ypos+= 20;
		}
		xpos = 650;
		ypos = 120;
		
		for(int x = 0; x < 10; x++){
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			ypos+= 20;
		}
		xpos = 50;
		ypos = 300;
		
		for(int x = 0; x < 7; x++){
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			//move bricks over so they don't overlap
			xpos+= 100;
		}
		xpos = 200;
		ypos = 140;
		
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 5; y++){
				addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
				ypos += 20;
			}
			ypos = 140;
			xpos += 150;
		}
	}
}
