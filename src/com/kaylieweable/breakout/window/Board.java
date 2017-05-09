package com.kaylieweable.breakout.window;
//allows access to JPanel library
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kaylieweable.breakout.framework.KeyInput;
import com.kaylieweable.breakout.framework.ObjectId;
import com.kaylieweable.breakout.objects.Ball;
import com.kaylieweable.breakout.window.Handler;
import com.kaylieweable.breakout.objects.Paddle;
//extends gives Board access to JPanel
public class Board extends JPanel implements Runnable{
//private sets variables specific to Board class
	private boolean running = false;
	private Thread thread;
	//only one instance of width an height --> static
	public static int WIDTH, HEIGHT;
	Handler handler;
	
	public Board(){
		
	}
	
	private void init(){
		//focuses on board; without, game pieces would not move --> built into JPanel
		setFocusable(true);
		//built into JPanel as well
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		handler = new Handler();
		//create paddle
		handler.addObject(new Paddle(100, 570, handler, ObjectId.Paddle));
		//create ball
		handler.addObject(new Ball(120, 548, handler, ObjectId.Ball));
		//invoke createLevel from handler and create level 1
		handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
	}
	
	public synchronized void start(){
		//concurrency = allowance of multiple activities at one time
		//establishes variable changes for all other threads
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		//public void run will not happen without
		thread.start();
	}
	//method specific to JPanel - override paintComponent method and draw what we want
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//background
		g.setColor(Color.black);
		//starts at top left corner
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//code to create our objects - invokes the render method
		handler.render(g);
		//get rid of any extra from the Graphics g object
		g.dispose();
	}
	//primary method for our application - will run whenever a thread is started
	public void run() {
		//call to private method init
		init();
		
		while(running){
			//game loop
			//invokes handler.move method
			move();
			//specific to JPanel - rerender after they move
			repaint();
			//try/catch block
			try{
				//thread sleeps 20 ms after move so everything can update before running/redrawing
				thread.sleep(23);
			}
			//if any errors, we can see them
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		
	}
	
	private void move(){
		handler.move();
	}
}

