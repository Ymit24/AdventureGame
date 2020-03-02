package com.christian.adventureeditor.ui.elements;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.christian.adventureeditor.ui.VerticalPushLayout;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;

public class InputTextField extends Element {
	public static final int DEFAULT_BORDER_THICKNESS = 4;
	public Label text;
	private Color borderColor;
	private Color backgroundColor;
	
	private int borderThickness;
	
	private Box outerContent;
	private Box innerContent;

	public InputTextField(VerticalPushLayout layout, String id, Label text) {
		super(layout, id);

		this.text = text;
		this.borderThickness = DEFAULT_BORDER_THICKNESS;
		this.borderColor = Color.white;
		this.backgroundColor = Color.black;
		
		text.bounds = innerContent;
	}
	
	@Override
	public void HandleKey(int keycode) {
		if (KeyEvent.VK_BACK_SPACE == keycode) {
			if (text.text.length() > 0) {
				text.text = text.text.substring(0, text.text.length()-1);				
			}			
		} else {
			text.text += KeyEvent.getKeyText(keycode);	
		}
	}
	
	public InputTextField SetPadding(Vector2 padding) {
		this.padding = padding;
		layout.RecalculateHeights();
		return this;
	}
	
	public InputTextField SetBorderColor(Color color) {
		this.borderColor = color;
		return this;
	}
	
	public InputTextField SetBackgroundColor(Color color) {
		this.backgroundColor = color;
		return this;
	}
	
	public InputTextField SetBorderThickness(int thickness) {
		this.borderThickness = thickness;
		layout.RecalculateHeights();
		return this;
	}

	@Override
	public void UpdateBounds(Box bounds) {
		this.bounds = bounds;
		
		outerContent = new Box(
			bounds.position.Add(new Vector2(padding.x/2,padding.y/2)),
			bounds.size.Sub(new Vector2(padding.x, padding.y))
		);
		innerContent = new Box(
			outerContent.position.Add(Vector2.One().Mul(borderThickness)),
			outerContent.size.Sub(Vector2.One().Mul(borderThickness*2))
		);
		text.UpdateBounds(innerContent);
	}

	@Override
	public int CalculateHeight() {
		return (int)text.CalculateHeight() + (int)padding.y*2 + borderThickness*2;
	}
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.FillBox(outerContent, borderColor);
		renderer.FillBox(innerContent, backgroundColor);
		text.draw(renderer);
	}
}
