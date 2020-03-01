package com.christian.adventureeditor.ui.elements;

import java.awt.Color;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;

public class InputTextField extends Element {
	public static final int DEFAULT_BORDER_THICKNESS = 4;
	private Label text;
	private Color borderColor;
	private Color backgroundColor;
	
	private int borderThickness;
	
	private Box outerContent;
	private Box innerContent;

	public InputTextField(Label text) {
		super((int)text.bounds.size.y + (int)DEFAULT_PADDING.y*2 + DEFAULT_BORDER_THICKNESS*2, DEFAULT_PADDING);

		this.text = text;
		this.borderThickness = DEFAULT_BORDER_THICKNESS;
		this.borderColor = Color.white;
		
		text.bounds = innerContent;
	}
	
	public InputTextField(Label text, Color borderColor, Color backgroundColor) {
		super((int)text.bounds.size.y + (int)DEFAULT_PADDING.y*2 + DEFAULT_BORDER_THICKNESS*2, DEFAULT_PADDING);

		System.out.println(text.bounds);
		this.text = text;
		this.borderThickness = DEFAULT_BORDER_THICKNESS;
		this.borderColor = borderColor;
		this.backgroundColor = backgroundColor;
		
		text.bounds = innerContent;
	}
	
	public InputTextField(Label text, Vector2 padding, int borderThickness, Color borderColor, Color backgroundColor) {
		super((int)text.bounds.size.y + (int)padding.y*2 + borderThickness*2, padding);
		
		this.text = text;
		this.borderThickness = borderThickness;
		this.borderColor = borderColor;
		this.backgroundColor = backgroundColor;
		
		text.bounds = innerContent;
	}
	
	@Override
	public void draw(IRenderer renderer) {
		outerContent = new Box(
			bounds.position.Add(new Vector2(padding.x/2,padding.y/2)),
			bounds.size.Sub(new Vector2(padding.x, padding.y))
		);
		innerContent = new Box(
			outerContent.position.Add(Vector2.One().Mul(borderThickness)),
			outerContent.size.Sub(Vector2.One().Mul(borderThickness*2))
		);
		text.bounds = innerContent;
		renderer.FillBox(outerContent, borderColor);
		renderer.FillBox(innerContent, backgroundColor);
		text.draw(renderer);
	}
}
