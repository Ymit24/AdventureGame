package com.christian.adventureeditor.ui.elements;

import com.christian.adventureeditor.ui.VerticalPushLayout;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;

public abstract class Element {
	public static final Vector2 DEFAULT_PADDING = new Vector2(4,4);
	public VerticalPushLayout layout;
	public Vector2 padding;
	public Box bounds;
	public String id;
	
	public Element(VerticalPushLayout layout, String id) {
		this.layout = layout;
		this.id = id;
		bounds = new Box(0,0,0,0);
		padding = Vector2.Zero();
	}
	
	public abstract void UpdateBounds(Box bounds);
	public abstract int CalculateHeight();
	
	public abstract void draw(IRenderer renderer);
}
