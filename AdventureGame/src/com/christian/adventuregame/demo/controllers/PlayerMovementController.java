package com.christian.adventuregame.demo.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.Player;
import com.christian.adventuregame.demo.utils.CollisionMovementUtil;

public class PlayerMovementController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Player player = State.world.player;
		Vector2 pos = player.Position;
		
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
		direction = direction.Mul(player.stats.moveSpeed);
		if (direction.Magnitude() > 0)
		{
			pos = pos.Add(direction.Mul(deltaTime));
			Vector2 newDir = CollisionMovementUtil.TryMove(player, direction.Mul(deltaTime));
			player.Position = player.Position.Add(newDir);
		}
	}
}
