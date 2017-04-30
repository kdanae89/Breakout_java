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
