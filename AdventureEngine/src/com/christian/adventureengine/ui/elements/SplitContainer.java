package com.christian.adventureengine.ui.elements;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.ui.VerticalPushLayout;

public class SplitContainer extends Element {
	private float splitPercent;

	public SplitContainer(VerticalPushLayout layout, String id, Element left, Element right, float splitPercent) {
		super(layout, id);
		children = new Element[2];
		children[0] = left;
		children[1] = right;
		this.splitPercent = splitPercent;
	}

	public SplitContainer(VerticalPushLayout layout, String id, Element[] children) {
		super(layout, id);
		this.children = children;
		this.splitPercent = 1 / (float) children.length;
	}

	@Override
	public void UpdateBounds(Box bounds) {
		this.bounds = bounds;
		if (children.length == 2) {
			children[0].UpdateBounds(new Box(
				bounds.position.x,
				bounds.position.y,
				bounds.size.x * splitPercent,
				bounds.size.y
			));
			children[1].UpdateBounds(new Box(
				bounds.position.x + bounds.size.x * splitPercent,
				bounds.position.y,
				bounds.size.x * (1 - splitPercent),
				bounds.size.y
			));
		} else {
			for (int i = 0; i < children.length; i++) {
				children[i].UpdateBounds(
					new Box(
						bounds.position.x + (bounds.size.x * (splitPercent * i)),
						bounds.position.y,
						bounds.size.x * splitPercent,
						bounds.size.y
					)
				);
			}
		}
	}
}