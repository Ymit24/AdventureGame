package com.christian.adventureeditor.ui;

import java.util.ArrayList;

import com.christian.adventureeditor.ui.elements.Element;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;

public class VerticalPushLayout {
	public Box bounds;
	
	public ArrayList<Element> elements;
	
	private int currentY;
	
	public static VerticalPushLayout Create(Box bounds) {
		VerticalPushLayout layout = new VerticalPushLayout();
		layout.bounds = bounds;
		
		layout.elements = new ArrayList<>();
		
		layout.currentY = (int)bounds.position.y;
		
		return layout;
	}
	
	public void RecalculateHeights() {
		currentY = (int)bounds.position.y;
		for (Element el : elements) {
			int height = el.CalculateHeight();
			el.UpdateBounds(new Box(0, currentY, bounds.size.x, height));
			currentY += height;
		}
	}
	
	public void PushElement(Element element) {
		element.bounds.position = new Vector2(0, currentY);
		currentY += element.bounds.size.y;
		
		elements.add(element);
	}
	
	public Element FindElementById(String id) {
		for (Element el : elements) {
			if (el.id == id) {
				return el;
			}
		}
		return null;
	}
}
