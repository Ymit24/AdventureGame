package com.christian.adventureeditor.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class CameraController extends Controller {
	private float size = 14;
	@Override
	public void Update(float deltaTime) {
		Vector2 direction = new Vector2();
		
		// TODO: Program middle mouse drag based movement
		
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_W)) {
			direction.y -= 1;
		}
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_S)) {
			direction.y += 1;
		}
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_A)) {
			direction.x -= 1;
		}
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_D)) {
			direction.x += 1;
		}
		if (direction.Magnitude() != 0)
			direction.Normalize();
		
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_Q)) {
			size -= 8 * deltaTime;
			Camera.GetCamera().UpdateBounds(Vector2.One().Mul(size));
		}
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_E)) {
			size += 8 * deltaTime;
			Camera.GetCamera().UpdateBounds(Vector2.One().Mul(size));
		}
		
		Camera.GetCamera().SetPosition(Camera.GetCamera().GetPosition().Add(direction.Mul(5*deltaTime)));
	}
}
