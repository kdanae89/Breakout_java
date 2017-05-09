package com.kaylieweable.breakout.objects;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.kaylieweable.breakout.framework.Level;
import com.kaylieweable.breakout.window.Board;
import com.kaylieweable.breakout.window.Handler;

public class MouseInput implements MouseListener{

	Handler handler;
	
	public MouseInput(Handler handler){
		this.handler = handler;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		//play button now works!
		if(x >= Board.WIDTH/3 + 75 && x < Board.WIDTH/3 + 175){
			if(y >= 150 && y <= 200){
				handler.setLevel(Level.level1);
			}
		}
		
		//Quit button now works!
		if(x >= Board.WIDTH/3 + 75 && x < Board.WIDTH/3 + 175){
			if(y >= 250 && y <= 300){
				System.exit(1);
			}
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

}
