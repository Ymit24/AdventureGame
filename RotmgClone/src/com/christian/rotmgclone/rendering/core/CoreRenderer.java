package com.christian.rotmgclone.rendering.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.christian.rotmgclone.data.world.Data;
import com.christian.rotmgclone.data.world.Vector2;
import com.christian.rotmgclone.input.Input;
import com.christian.rotmgclone.input.core.KeyboardListener;
import com.christian.rotmgclone.rendering.IRenderer;

public class CoreRenderer implements IRenderer {
	public static final int DISPLAY_WIDTH = 1280;
	public static final int DISPLAY_HEIGHT = 720;
	
	private Window window;
	private Canvas canvas;
	
	private BufferStrategy bufferStrategy;
	
	public CoreRenderer() {
	}
	
	public void Initialize() {
		canvas = new Canvas();
		window = new Window(DISPLAY_WIDTH, DISPLAY_HEIGHT, canvas);
	}
	
	public void CreateInput() {
		KeyboardListener keyboardListener = new KeyboardListener();
		canvas.addKeyListener(keyboardListener);
		Input.keyboardListener = keyboardListener;
	}

	@Override
	public void OnRender() {
		if (bufferStrategy == null) {
			canvas.createBufferStrategy(2);
			bufferStrategy = canvas.getBufferStrategy();
		}
		
		Graphics g = bufferStrategy.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);

		Vector2 position = Data.world.GetPlayer().GetPosition();
		
		g.setColor(Color.red);
		g.fillRect((int)position.x, (int)position.y, 100, 100);
		
		bufferStrategy.show();
		g.dispose();
	}
}
