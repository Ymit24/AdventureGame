package com.christian.adventureengine.demo.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.demo.data.Data;
import com.christian.adventureengine.demo.data.Player;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class BulletSpawnController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Player player = Data.world.GetPlayer();
		player.ShootingTimer -= deltaTime;
		if ((Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SPACE) ||
			Input.GetMouseListener().isMouseButtonDown(0)) && player.ShootingTimer <= 0) {
			player.ShootingTimer = Player.SECONDS_PER_SHOT;
			Vector2 mousePosition = Input.GetMouseListener().GetPosition();
			mousePosition = Camera.GetCamera().CalculateScreenToWorld(mousePosition);
			System.out.println(mousePosition);
			Vector2 playerPos = Data.world.GetPlayer().GetPosition().Add(new Vector2(0.5f,0.5f));
			Vector2 direction = new Vector2(mousePosition.x - playerPos.x, mousePosition.y - playerPos.y).Normalized();
			
			Data.world.SpawnBullet(playerPos.Add(direction.Mul(0.75f)), direction);
		}
	}
}
