package com.christian.adventureeditor.ui.elements;

import java.awt.Color;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;

public class Button extends Element {
	private Label text;
	private Color borderColor;
	private Color backgroundColor;
	
	private int borderThickness;
	
	private Box outerContent;
	private Box innerContent;
	
	public Button(Label text) {
		super((int)text.bounds.size.y);
		
		this.text = text;
		this.borderColor = Color.white;
		this.backgroundColor = Color.black;
		this.borderThickness = 4;
	}

	public Button(Label text, Vector2 padding) {
		super((int)(text.bounds.size.y + padding.y*2), padding);
		
		this.text = text;
		this.borderColor = Color.white;
		this.backgroundColor = Color.black;
		this.borderThickness = 4;
	}
	
	public Button SetBorderColor(Color color) {
		this.borderColor = color;
		return this;
	}
	
	public Button SetBackgroundColor(Color color) {
		this.backgroundColor = color;
		return this;
	}
	
	public Button SetBorderThickness(int thickness) {
		this.borderThickness = thickness;
		return this;
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
