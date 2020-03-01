package com.christian.adventureeditor.ui.elements;

import com.christian.adventureeditor.ui.UI;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;

public abstract class Element {
	public static final Vector2 DEFAULT_PADDING = new Vector2(4,4);
	public Vector2 padding;
	public Box bounds;
	
	public Element(int height) {
		this.padding = DEFAULT_PADDING;
		
		bounds = new Box(0,0,0,0);
		
		bounds.size = new Vector2(UI.bounds.size.x, height);
	}

	public Element(int height, Vector2 padding) {
		this.padding = padding;
		
		bounds = new Box(0,0,0,0);
		
		bounds.size = new Vector2(UI.bounds.size.x, height);
	}
	
	public Element SetPadding(Vector2 padding) {
		this.padding = padding;
		return this;
	}
	
	public abstract void draw(IRenderer renderer);
}
