package com.christian.adventureeditor.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseClickListener;
import com.christian.adventureengine.input.IMouseScrollListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class CameraController extends Controller implements IMouseScrollListener, IMouseClickListener {
	private float size = 14;
	private Vector2 lastMousePos = Vector2.Zero();
	
	public CameraController() {
		Input.GetMouseListener().AddMouseScrollListener(this);
		Input.GetMouseListener().AddMouseClickListener(this);
	}
	
	@Override
	public void OnScroll(int delta) {
		size += delta;
		Camera.GetCamera().CenterZoom(size);
	}

	@Override
	public boolean OnClick(Vector2 screenLocation, int button, boolean isDown) {
		if (button != 1 || !isDown)
			return false;
		
		lastMousePos = new Vector2(screenLocation);
		return false;
	}
	
	@Override
	public void Update(float deltaTime) {
		Vector2 direction = new Vector2();
		
		if (Input.GetMouseListener().isMouseButtonDown(1)) {
			Vector2 moveBy = Input.GetMouseListener().GetPosition().Sub(lastMousePos);
			
			Camera.GetCamera().Move(Camera.GetCamera().ConvertPixelToWorldUnit(moveBy).Mul(-1));
			lastMousePos = new Vector2(Input.GetMouseListener().GetPosition());
		}
	}
}
