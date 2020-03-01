package com.christian.adventureeditor.ui.elements;

import com.christian.adventureeditor.ui.VerticalPushLayout;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.rendering.IRenderer;

public class InputTextFieldAndLabel extends Element {
	public Label label;
	public InputTextField input;
	private float splitPercent;
	
	public InputTextFieldAndLabel(VerticalPushLayout layout, String id, Label label, InputTextField input, float splitPercent) {
		super(layout, id);
		this.label = label;
		this.input = input;
		this.splitPercent = splitPercent;
	}
	
	@Override
	public void UpdateBounds(Box bounds) {
		this.bounds = bounds;
		System.out.println(bounds);
		label.UpdateBounds(new Box(
			bounds.position.x,
			bounds.position.y,
			bounds.size.x*splitPercent,
			bounds.size.y
		));
		input.UpdateBounds(new Box(
			bounds.position.x+bounds.size.x*splitPercent,
			bounds.position.y,
			bounds.size.x*(1-splitPercent),
			bounds.size.y
		));
	}
	
	@Override
	public int CalculateHeight() {
		return (int)Math.max(label.CalculateHeight(), input.CalculateHeight());
	}
	
	@Override
	public void draw(IRenderer renderer) {
		label.draw(renderer);
		input.draw(renderer);
	}
}
