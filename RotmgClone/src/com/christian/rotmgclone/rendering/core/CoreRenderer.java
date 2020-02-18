package com.christian.rotmgclone.rendering.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.christian.rotmgclone.data.world.Vector2;
import com.christian.rotmgclone.input.Input;
import com.christian.rotmgclone.input.core.KeyboardListener;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.sprites.Sprite;
import com.christian.rotmgclone.rendering.sprites.Sprites;
import com.christian.rotmgclone.views.View;

public class CoreRenderer implements IRenderer {
	public static final int DISPLAY_WIDTH = 1280;
	public static final int DISPLAY_HEIGHT = 720;
	
	private Window window;
	private Canvas canvas;
	
	private BufferStrategy bufferStrategy;
	private View rootView;

	private Graphics graphics;
	private boolean canDraw;
	
	public CoreRenderer() {
		canDraw = false;
	}
	
	@Override
	public void Initialize() {
		canvas = new Canvas();
		window = new Window(DISPLAY_WIDTH, DISPLAY_HEIGHT, canvas);
	}

	@Override
	public void CreateInput() {
		KeyboardListener keyboardListener = new KeyboardListener();
		canvas.addKeyListener(keyboardListener);
		Input.keyboardListener = keyboardListener;
	}

	@Override
	public void CreateSpriteManager() {
		SpriteManager spriteManager = new SpriteManager();
		Sprites.SetSpriteManager(spriteManager);
	}

	@Override
	public void SetRootView(View view) {
		this.rootView = view;
	}

	@Override
	public void DrawSprite(Sprite sprite, Vector2 location) {
		if (canDraw == false)
			return;
		graphics.drawImage(sprite.GetImage(), (int)location.x, (int)location.y, null);
	}
	
	@Override
	public void OnRender() {
		if (bufferStrategy == null) {
			canvas.createBufferStrategy(2);
			bufferStrategy = canvas.getBufferStrategy();
		}
		
		graphics = bufferStrategy.getDrawGraphics();
		canDraw = true;
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);

		if (rootView != null) {
			rootView.draw(this);
		}
		
		canDraw = false;
		bufferStrategy.show();
		graphics.dispose();
	}
}
