package de.ironcrone.war.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import de.ironcrone.war.graphics.Window;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 6949898106588048919L;

	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9;
	
	private boolean isRunning = false;
	private Thread thread;
	
	public Game() {
		
		new Window(WIDTH, HEIGHT, "WAR", this);
		
		start();
		
	}
	
	private void start() {
		
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	private void stop() {
		
		isRunning = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		
		while(isRunning) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				update();
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		
		stop();
		
	}
	
	public void update() {
		
		
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			//this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		//draw

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//draw
		
		g.dispose();
		bs.show();
		
	}
	
}
