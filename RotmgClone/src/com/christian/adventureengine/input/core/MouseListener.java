package com.christian.adventureengine.input.core;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseListener;

public class MouseListener implements IMouseListener, MouseInputListener {

	public static final int LEFT = 0;
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;

	private Vector2 position;
	private boolean[] states;
	
	public MouseListener() {
		states = new boolean[3];
		position = new Vector2();
	}
	
	public int getX() {
		return (int)position.x;
	}
	
	public int getY() {
		return (int)position.y;
	}
	
	public Vector2 GetPosition() {
		return this.position;
	}
	
	public boolean isMouseButtonDown(int button) {
		if (button < 0 && button > 2) {
			return false;
		}
		
		return states[button];
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		position.x = event.getX();
		position.y = event.getY();

		switch (event.getButton()) {
		case MouseEvent.BUTTON1:
			states[LEFT] = true;
			break;
		case MouseEvent.BUTTON2:
			states[RIGHT] = true;
			break;
		case MouseEvent.BUTTON3:
			states[MIDDLE] = true;
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		position.x = event.getX();
		position.y = event.getY();

		switch (event.getButton()) {
		case MouseEvent.BUTTON1:
			states[LEFT] = false;
			break;
		case MouseEvent.BUTTON2:
			states[RIGHT] = false;
			break;
		case MouseEvent.BUTTON3:
			states[MIDDLE] = false;
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		position.x = event.getX();
		position.y = event.getY();
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		position.x = event.getX();
		position.y = event.getY();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}
}
