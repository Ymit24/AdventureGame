package com.christian.adventureeditor.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class CameraController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Vector2 direction = new Vector2();
		
		// TODO: Program middle mouse drag based movement
		
		Camera.GetCamera().SetPosition(Camera.GetCamera().GetPosition().Add(direction.Mul(3*deltaTime)));
	}
}
