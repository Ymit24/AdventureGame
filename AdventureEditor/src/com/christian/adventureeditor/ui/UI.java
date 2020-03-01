package com.christian.adventureeditor.ui;

import java.util.ArrayList;

import com.christian.adventureeditor.ui.elements.Element;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;

public class UI {
	public static int margin;
	public static Box bounds;
	
	public static ArrayList<Element> elements;
	
	private static int currentY;
	
	public static void Create(Box bounds) {
		Create(bounds, 0);
	}
	
	public static void Create(Box bounds, int margin) {
		UI.bounds = bounds;
		UI.margin = margin;
		
		UI.elements = new ArrayList<>();
		
		currentY = (int)bounds.position.y + margin;
	}
	
	public static void PushElement(Element element) {
		element.bounds.position = new Vector2(0, currentY);
		currentY += element.bounds.size.y + margin;
		
		elements.add(element);
	}
}
