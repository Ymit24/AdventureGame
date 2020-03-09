package com.christian.adventureengine.ui.elements;

import java.awt.Color;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;

public class Button extends Element {
	public Label text;
	private Color borderColor;
	private Color backgroundColor;
	
	private int borderThickness;
	
	private Box outerContent;
	private Box innerContent;
	
	private IButtonCallback callback;
	
	public Button(VerticalPushLayout layout, String id, Label text) {
		super(layout, id);
		
		this.text = text;
		this.borderColor = Color.white;
		this.backgroundColor = Color.black;
		this.borderThickness = 4;
	}
	
	public Button SetPadding(Vector2 padding) {
		this.padding = padding;
		layout.RecalculateHeights();
		return this;
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
		layout.RecalculateHeights();
		return this;
	}
	
	public Button SetCallback(IButtonCallback callback) {
		this.callback = callback;
		return this;
	}
	
	@Override
	public void HandleClick(boolean isDown) {
		if (callback != null) {
			callback.OnButtonClicked(id);
		}
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
		return (int)(text.CalculateHeight() + padding.y*2);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.FillBox(outerContent, borderColor);
		renderer.FillBox(innerContent, backgroundColor);
		text.draw(renderer);
	}
}
