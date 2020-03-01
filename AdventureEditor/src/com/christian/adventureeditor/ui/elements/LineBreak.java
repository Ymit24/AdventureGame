package com.christian.adventureeditor.ui.elements;

import java.awt.Color;

import com.christian.adventureeditor.ui.VerticalPushLayout;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.rendering.IRenderer;

public class LineBreak extends Element {
	private int height;
	private Color color;
	
	public LineBreak(VerticalPushLayout layout, String id, int height) {
		super(layout, id);
		this.height = height;
		color = Color.white;
	}

	public LineBreak SetColor(Color color) {
		this.color = color;
		return this;
	}
	
	@Override
	public int CalculateHeight() {
		return height;
	}

	@Override
	public void UpdateBounds(Box bounds) {
		this.bounds = bounds;
	}
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.FillBox(bounds, color);
	}
}
