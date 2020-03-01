package com.christian.adventureeditor.ui.elements;

import java.awt.Color;

import com.christian.adventureengine.rendering.IRenderer;

public class LineBreak extends Element {
	private Color color;
	public LineBreak(int height) {
		super(height);
		color = Color.white;
	}

	public LineBreak(int height, Color color) {
		super(height);
		this.color = color;
	}
	
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.FillBox(bounds, color);
	}
}
