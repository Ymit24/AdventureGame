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
		
	}
}
