package com.kaylieweable.breakout.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.kaylieweable.breakout.window.Handler;

public class KeyInput extends KeyAdapter{
	
	Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		//test the event and turns into int var to compare other key events to
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			//test if tempObject is a paddle
			if(tempObject.getId() == ObjectId.Paddle){
				//if the left key was pressed
				if(key == KeyEvent.VK_LEFT){
					//send paddle to the left
					tempObject.setVelX(-10);
				}
				//if the right key was pressed
				if(key == KeyEvent.VK_RIGHT){
					//send paddle to the right
					tempObject.setVelX(10);
				}
			}
			//if state dead allow spacebar to start game
			if(tempObject.getId() == ObjectId.Ball){
				if(key == KeyEvent.VK_SPACE){
					if(handler.getState() == State.dead){
						handler.setState(State.alive);
						
						tempObject.setVelY(-8);
						tempObject.setVelX(-8);
					}
				}
			}
		}
		//if p is pushed, pause or unpause
		if(key == KeyEvent.VK_P){
			if(handler.getState() == State.alive){
				handler.setState(State.paused);
			}
			else if(handler.getState() == State.paused){
				handler.setState(State.alive);
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			//test if tempObject is a paddle
			if(tempObject.getId() == ObjectId.Paddle){
				//if the left key was pressed
				if(key == KeyEvent.VK_LEFT){
					//send paddle to the left
					tempObject.setVelX(0);
				}
				//if the right key was pressed
				if(key == KeyEvent.VK_RIGHT){
					//send paddle to the right
					tempObject.setVelX(0);
				}
			}
		}
	}

}
