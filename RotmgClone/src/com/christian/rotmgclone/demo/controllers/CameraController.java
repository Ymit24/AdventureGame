package com.christian.rotmgclone.demo.controllers;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.demo.data.Data;
import com.christian.rotmgclone.input.Input;
import com.christian.rotmgclone.logic.Controller;
import com.christian.rotmgclone.rendering.Camera;

public class CameraController extends Controller {
	@Override
	public void Update(float deltaTime) {
//		Camera.GetCamera().SetPosition(Data.world.GetPlayer().GetPosition());
		if (Input.GetMouseListener().isMouseButtonDown(1)) {
			Camera camera = Camera.GetCamera();
			Vector2 mouseWorld = camera.CalculateScreenToWorld(Input.GetMouseListener().GetPosition());
			Vector2 relative = new Vector2(camera.GetPosition()).Add(new Vector2(camera.GetWorldSpace().x/2,camera.GetWorldSpace().y/2));
//			Vector2 relative = new Vector2(Data.world.GetPlayer().GetPosition());
			mouseWorld.Sub(relative).Normalized().Multiply(3);
			System.out.println(relative.toString() + " " + mouseWorld);
			camera.SetPosition(mouseWorld);
		}
	}
}
