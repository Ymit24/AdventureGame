package com.christian.rotmgclone.demo;

import java.awt.event.KeyEvent;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.demo.data.Data;
import com.christian.rotmgclone.demo.data.Player;
import com.christian.rotmgclone.input.Input;
import com.christian.rotmgclone.logic.Controller;

public class DemoController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Player player = Data.world.GetPlayer();
		Vector2 pos = player.GetPosition();
		float speed = 48;
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SHIFT)) {
			speed = 640;
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
