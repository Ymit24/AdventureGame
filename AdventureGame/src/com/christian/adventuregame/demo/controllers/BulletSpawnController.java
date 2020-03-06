package com.christian.adventuregame.demo.controllers;

import java.awt.event.KeyEvent;
import java.util.Random;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.Player;
import com.christian.adventuregame.demo.data.WeaponArchetypes;
import com.christian.adventuregame.demo.data.WeaponType;
import com.christian.adventuregame.demo.utils.ProjectileEmitterUtil;

public class BulletSpawnController extends Controller {
	@Override
	public void Update(float deltaTime) {
		Player player = State.world.player;
		player.ShootingTimer -= deltaTime;
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SPACE) && player.ShootingTimer <= 0) {
			player.ShootingTimer = Player.SECONDS_PER_SHOT;
			Vector2 mousePosition = Input.GetMouseListener().GetPosition();
			mousePosition = Camera.GetCamera().CalculateScreenToWorld(mousePosition);

			Vector2 playerPos = State.world.player.Position.Add(new Vector2(0.5f,0.5f));
			Vector2 direction = new Vector2(mousePosition.x - playerPos.x, mousePosition.y - playerPos.y).Normalized();

			WeaponType[] allTypes = WeaponArchetypes.GetAll();
			ProjectileEmitterUtil.Emit(allTypes[Randomizer.random.nextInt(allTypes.length)], playerPos, direction);

			AudioPlayer.Play("shoot.wav");
		}
		if (Input.GetMouseListener().isMouseButtonDown(0) && player.ShootingTimer <= 0) {
			player.ShootingTimer = Player.SECONDS_PER_SHOT;
			Vector2 mousePosition = Input.GetMouseListener().GetPosition();
			mousePosition = Camera.GetCamera().CalculateScreenToWorld(mousePosition);

			Vector2 playerPos = State.world.player.Position.Add(new Vector2(0.5f,0.5f));
			Vector2 direction = new Vector2(mousePosition.x - playerPos.x, mousePosition.y - playerPos.y).Normalized();

			WeaponType[] allTypes = WeaponArchetypes.GetAll();
			ProjectileEmitterUtil.Emit(player.weaponType, playerPos, direction);

			AudioPlayer.Play("shoot.wav");
		}
	}
}
