package com.kaylieweable.breakout.framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.kaylieweable.breakout.window.Board;

public class Menu {
	
	public Rectangle startButton = new Rectangle(Board.WIDTH/3 + 75, 150, 100, 50);
	public Rectangle quitButton = new Rectangle(Board.WIDTH/3 + 75, 250, 100, 50);

	public void render(Graphics g){
		
		Font font = new Font("arial", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.GREEN);
		g.drawString("Breakout!", Board.WIDTH/3, 100);
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font font2 = new Font("arial", Font.BOLD, 30);
		g.setFont(font2);
		g.setColor(Color.CYAN);
		g.drawString("Play", Board.WIDTH/3 + 97, 185);
		g.drawString("Quit", Board.WIDTH/3 + 97, 285);
		
		g2d.draw(startButton);
		g2d.draw(quitButton);
	}
}
