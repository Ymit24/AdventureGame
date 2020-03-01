package com.christian.adventureeditor.ui.elements;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.rendering.IRenderer;

public class InputTextFieldAndLabel extends Element {
	private Label label;
	private InputTextField input;
	private float splitPercent;
	
	public InputTextFieldAndLabel(Label label, InputTextField input, float splitPercent) {
		super((int)Math.max(label.bounds.size.y, input.bounds.size.y));
		this.label = label;
		this.input = input;
		this.splitPercent = splitPercent;
	}
	
	@Override
	public void draw(IRenderer renderer) {
		label.bounds = new Box(
			bounds.position.x,
			bounds.position.y,
			bounds.size.x*splitPercent,
			bounds.size.y
		);
		input.bounds = new Box(
			bounds.position.x+bounds.size.x*splitPercent,
			bounds.position.y,
			bounds.size.x*(1-splitPercent),
			bounds.size.y
		);
		
		label.draw(renderer);
		input.draw(renderer);
	}
}
