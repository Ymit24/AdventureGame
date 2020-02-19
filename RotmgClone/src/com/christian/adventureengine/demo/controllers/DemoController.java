package com.christian.adventureengine.demo.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.demo.data.Data;
import com.christian.adventureengine.demo.data.Player;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;

public class DemoController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Player player = Data.world.GetPlayer();
		Vector2 pos = player.GetPosition();
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
		direction.Multiply(speed);
		if (direction.Magnitude() > 0)
		{
			pos.Add(direction.Multiply(deltaTime));
			player.SetPosition(pos);		
		}
	}
}
