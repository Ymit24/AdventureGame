package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventuregame.demo.data.State;

public class CameraController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Camera.GetCamera().SetPosition(State.world.player.Position.Sub(Camera.GetCamera().GetWorldSpace().Div(2)));
	}
}
