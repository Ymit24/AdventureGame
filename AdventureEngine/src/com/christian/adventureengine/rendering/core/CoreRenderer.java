package com.christian.adventureengine.rendering.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.input.core.KeyboardListener;
import com.christian.adventureengine.input.core.MouseListener;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;

public class CoreRenderer implements IRenderer {
	private int displayWidth = 1280;
	private int displayHeight = 720;
	
	private Window window;
	private Canvas canvas;
	
	private BufferStrategy bufferStrategy;
	private View rootView;

	private Graphics graphics;
	private boolean canDraw;
	
	private Font defaultFont;
	private Camera camera;
	
	public CoreRenderer() {
		canDraw = false;
		defaultFont = new Font("Arial", Font.BOLD, 24);
	}
	
	@Override
	public void Initialize(String windowTitle, int width, int height) {
		displayWidth = width;
		displayHeight = height;
		canvas = new Canvas();
		window = new Window(windowTitle, displayWidth, displayHeight, canvas);
		
		if (bufferStrategy == null) {
			canvas.createBufferStrategy(2);
			bufferStrategy = canvas.getBufferStrategy();
		}
		
		graphics = bufferStrategy.getDrawGraphics();
	}

	@Override
	public void CreateInput() {
		KeyboardListener keyboardListener = new KeyboardListener();
		MouseListener mouseListener = new MouseListener();
		
		canvas.addKeyListener(keyboardListener);
		canvas.addMouseListener(mouseListener);
		Input.SetKeyboardListener(keyboardListener);
		Input.SetMouseListener(mouseListener);
		canvas.addMouseMotionListener(mouseListener);
	}

	@Override
	public void CreateCamera(Vector2 worldSpaceView) {
		CreateCamera(worldSpaceView, new Vector2(displayWidth, displayHeight));
	}
	
	@Override
	public void CreateCamera(Vector2 worldSpaceView, Vector2 screenSpace) {
		assert(screenSpace.x > 0 && screenSpace.x <= displayWidth && screenSpace.y > 0 && screenSpace.y <= displayHeight);
		Vector2 pixelsPerWorldUnit = new Vector2(
			screenSpace.x / worldSpaceView.x,
			screenSpace.y / worldSpaceView.y
		);
		camera = new Camera(pixelsPerWorldUnit, worldSpaceView);
		
		System.out.println("Pixels per world unit: " + pixelsPerWorldUnit.toString());
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
	public void DrawSprite(Sprite sprite, Vector2 worldLocation) {
		if (canDraw == false)
			return;
		Vector2 pixelLocation = camera.CalculateWorldToScreen(worldLocation);

		graphics.drawImage(
			sprite.GetImage(),
			(int)pixelLocation.x,
			(int)pixelLocation.y,
			(int)((camera.GetPixelsPerWorldUnit().x / sprite.PixelsToWorld.x) * sprite.GetImage().getWidth()),
			(int)((camera.GetPixelsPerWorldUnit().y / sprite.PixelsToWorld.y) * sprite.GetImage().getHeight()),
			null
		);
	}
	
	@Override
	public void DrawText(String message, Vector2 worldLocation) {
		if (canDraw == false)
			return;
		
		graphics.setColor(Color.white);
		Vector2 pixelLocation = camera.CalculateWorldToScreen(worldLocation);
		graphics.drawString(message, (int)pixelLocation.x, (int)pixelLocation.y);
	}
	
	@Override
	public void OnRender() {
		graphics = bufferStrategy.getDrawGraphics();
		graphics.setFont(defaultFont);
		
		canDraw = true;
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, displayWidth, displayHeight);

		if (rootView != null) {
			rootView.draw(this);
		}
		
		canDraw = false;
		bufferStrategy.show();
		graphics.dispose();
	}
}
