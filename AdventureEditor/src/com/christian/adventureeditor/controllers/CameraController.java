package com.christian.adventureeditor.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IKeyboardListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class CameraController extends Controller {
	@Override
	public void Update(float deltaTime) {
		IKeyboardListener listener = Input.GetKeyboardListener();
		Vector2 direction = new Vector2();
		
		if (listener.isKeyDown(KeyEvent.VK_W)) {
			direction.y -= 1;
		}
		if (listener.isKeyDown(KeyEvent.VK_S)) {
			direction.y += 1;
		}
		if (listener.isKeyDown(KeyEvent.VK_A)) {
			direction.x -= 1;
		}
		if (listener.isKeyDown(KeyEvent.VK_D)) {
			direction.x += 1;
		}
		
		Camera.GetCamera().SetPosition(Camera.GetCamera().GetPosition().Add(direction.Mul(5*deltaTime)));
	}
}
