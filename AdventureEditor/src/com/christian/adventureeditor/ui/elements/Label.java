package com.christian.adventureeditor.ui.elements;

import java.awt.Color;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;

public class Label extends Element {
	public enum Alignment {
		LEFT, CENTER, RIGHT
	}
	public static final int DEFAULT_FONT_SIZE = 16;
	public String text;
	public int fontSize;
	public Color fontColor;
	
	public Alignment alignment;
	
	public Label(String text) {
		super(DEFAULT_FONT_SIZE + (int)DEFAULT_PADDING.y*2);
		
		this.text = text;
		this.fontColor = Color.white;
		this.fontSize = DEFAULT_FONT_SIZE;
		this.alignment = Alignment.CENTER;
	}
	
	public Label(String text, int fontSize) {
		super(fontSize + (int)DEFAULT_PADDING.y*2);

		this.text = text;
		this.fontSize = fontSize;
		this.fontColor = Color.white;
		this.alignment = Alignment.CENTER;
	}

	public Label(String text, int fontSize, Color fontColor) {
		super(fontSize + (int)DEFAULT_PADDING.y*2);
		
		this.text = text;
		this.fontSize = fontSize;
		this.fontColor = fontColor;
		this.alignment = Alignment.CENTER;
	}

	public Label(String text, int fontSize, Vector2 padding, Color fontColor) {
		super(fontSize + (int)padding.y*2, padding);
		
		this.text = text;
		this.fontSize = fontSize;
		this.fontColor = fontColor;
		this.alignment = Alignment.CENTER;
	}
	
	public Label SetAlignment(Alignment alignment) {
		this.alignment = alignment;
		return this;
	}

	@Override
	public void draw(IRenderer renderer) {
		renderer.SetColor(fontColor);
		renderer.SetFontSize(fontSize);
		int x = (int)bounds.position.x;
		int y = (int)bounds.position.y;
		if (alignment == Alignment.CENTER) {
			Vector2 center = Box.Center(bounds, new Vector2(renderer.GetFontWidth(text), fontSize));
			x = (int)center.x;
			y = (int)center.y;
//			x = (int)(bounds.position.x + ((bounds.size.x / 2) - renderer.GetFontWidth(text) / 2));
//			y = (int)(bounds.position.y + ((bounds.size.y / 2) - fontSize / 2));
		} else if (alignment == Alignment.LEFT) {
			x = (int)(bounds.position.x + padding.x);
			y = (int)(bounds.position.y + ((bounds.size.y / 2) - fontSize / 2));
		} else if (alignment == Alignment.RIGHT) {
			x = (int)(bounds.position.x + bounds.size.x - renderer.GetFontWidth(text) - padding.x);
			y = (int)(bounds.position.y + ((bounds.size.y / 2) - fontSize / 2));
		}
//		renderer.FillBox(bounds, Color.green);
		renderer.DrawScreenText(text, new Vector2(x, y));
	}
}
