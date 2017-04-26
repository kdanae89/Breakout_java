package com.kaylieweable.breakout.window;
//imports Dimension library
import java.awt.Dimension;
//imports JFrame library
import javax.swing.JFrame;

public class Window {
//public available outside of class
//	this is a constructor vvv(always public)
	//default constructor
	public Window(int w, int h, String title, Board board){
		//code runs immediately as an object of our class is created
		board.setPreferredSize(new Dimension(w,h));
		board.setMaximumSize(new Dimension(w,h));
		board.setMinimumSize(new Dimension(w,h));
		//houses and contains things like JPanels - it's a top level container for swing GUIs
		//Swing GUI cannot exist without a top level container
		JFrame frame = new JFrame(title);
		//adds board to JFrame
		frame.add(board);
		//setting frame dimensions = to board
		frame.pack();
		//jframe dissapear once we exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dont want our frame to resize
		frame.setResizable(false);
		//want our board in the middle of our screen
		frame.setLocationRelativeTo(null);
		//want our board to show up duh?
		frame.setVisible(true);
		
		board.start();
	}
//	needed to run app unless applet
//	always in window.java
	public static void main(String[] args){
		//this would create a variable if we were to create more than one, same with board
		//Window window = new Window(800, 600, "Breakout!", new Board());
		
		new Window(800, 600, "Breakout!", new Board());
		
	}	
}
