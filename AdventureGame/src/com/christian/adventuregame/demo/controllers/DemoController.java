package com.christian.adventuregame.demo.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.Player;

public class DemoController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Player player = State.world.GetPlayer();
		Vector2 pos = player.Position;
		float speed = 2;
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SHIFT)) {
			speed = 4;
		}
		
		Vector2 direction = new Vector2();
		
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
		
		direction.Normalize();
		direction = direction.Mul(speed);
		if (direction.Magnitude() > 0)
		{
			pos = pos.Add(direction.Mul(deltaTime));
			player.Position = pos;		
		}
	}
}
