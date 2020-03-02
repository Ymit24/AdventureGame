package com.christian.adventureeditor.ui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.christian.adventureeditor.ui.elements.Element;
import com.christian.adventureeditor.ui.elements.InputTextField;
import com.christian.adventureeditor.ui.elements.SplitContainer;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IKeyListener;
import com.christian.adventureengine.input.IMouseClickListener;

public class VerticalPushLayout implements IMouseClickListener, IKeyListener {
	public Box bounds;
	
	public ArrayList<Element> elements;
	
	private int currentY;
	
	public Element active;
	
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

	@Override
	public void OnClick(Vector2 screenLocation, int button) {
		if (bounds.Includes(screenLocation)) {
			System.out.println("Clicked on ui");
			
			for (Element el : elements) {
				if (el.HitTest(screenLocation)) {
					if (active != null) {
						active.isActive = false;						
					}
					active = el;
					el.isActive = true;
					
				}
			}
		}
	}

	@Override
	public void OnKey(int keycode, boolean isDown) {
		if (!isDown)
			return;
		System.out.println(KeyEvent.getKeyText(keycode));
		if (active != null) {
			active.HandleKey(keycode);
		}
	}
}
