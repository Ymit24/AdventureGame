package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventuregame.demo.data.Data;

public class CameraController extends Controller {
	@Override
	public void Update(float deltaTime) {
		if (Input.GetMouseListener().isMouseButtonDown(1)) {
			Camera camera = Camera.GetCamera();

			Vector2 mouseWorld = camera.CalculateScreenToWorld(Input.GetMouseListener().GetPosition());
			mouseWorld = mouseWorld.Sub(camera.GetCenterPosition());
			
			mouseWorld = Data.world.GetPlayer().GetPosition().Sub(Camera.GetCamera().GetWorldSpace().Div(2)).Add(new Vector2(0.5f,0.5f)).Add(mouseWorld);
			
			camera.SetPosition(mouseWorld);
		}
	}
}
