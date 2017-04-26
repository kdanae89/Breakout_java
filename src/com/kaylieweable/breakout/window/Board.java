package com.kaylieweable.breakout.window;
//allows access to JPanel library
import javax.swing.JPanel;
//extends gives Board access to JPanel
public class Board extends JPanel implements Runnable{
//private sets variables specific to Board class
	private boolean running = false;
	private Thread thread;
	//only one instance of width an height --> static
	private static int WIDTH, HEIGHT;
	
	public Board(){
		
	}
	
	private void init(){
		//focuses on board; without, game pieces would not move --> built into JPanel
		setFocusable(true);
		//built into JPanel as well
		WIDTH = getWidth();
		HEIGHT = getHeight();
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
	//primary method for our application - will run whenever a thread is started
	public void run() {
		//call to private method init
		init();
		
		
	}
}

