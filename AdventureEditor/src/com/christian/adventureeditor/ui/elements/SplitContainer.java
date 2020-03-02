package com.christian.adventureeditor.ui.elements;

import com.christian.adventureeditor.ui.VerticalPushLayout;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.rendering.IRenderer;

public class SplitContainer extends Element {
	private float splitPercent;
	
	public SplitContainer(VerticalPushLayout layout, String id, Element left, Element right, float splitPercent) {
		super(layout, id);
		children = new Element[2];
		children[0] = left;
		children[1] = right;
		this.splitPercent = splitPercent;
	}
	
	@Override
	public void UpdateBounds(Box bounds) {
		this.bounds = bounds;
		children[0].UpdateBounds(new Box(
			bounds.position.x,
			bounds.position.y,
			bounds.size.x*splitPercent,
			bounds.size.y
		));
		children[1].UpdateBounds(new Box(
			bounds.position.x+bounds.size.x*splitPercent,
			bounds.position.y,
			bounds.size.x*(1-splitPercent),
			bounds.size.y
		));
	}
}
