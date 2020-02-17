package com.christian.rotmgclone.rendering.cpu;

import java.awt.Canvas;

import com.christian.rotmgclone.rendering.IRenderer;

public class CPURenderer implements IRenderer {
	public static final int DISPLAY_WIDTH = 1280;
	public static final int DISPLAY_HEIGHT = 720;
	
	private Window window;
	private Canvas canvas;
	
	public CPURenderer() {
	}
	
	public void Initialize() {
		canvas = new Canvas();
		window = new Window(DISPLAY_WIDTH, DISPLAY_HEIGHT, canvas);
	}

	@Override
	public void OnRender() {
=======
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
>>>>>>> Stashed changes
		
	}
}
