package com.christian.adventuregame.demo.controllers;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseClickListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.Player;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.WeaponType;
import com.christian.adventuregame.demo.utils.ProjectileEmitterUtil;

public class BulletSpawnController extends Controller implements IMouseClickListener {

	private boolean isShooting = false;
	public BulletSpawnController() {
		Input.GetMouseListener().AddMouseClickListener(this);
	}

	@Override
	public void Update(float deltaTime) {
		Player player = State.world.player;
		player.ShootingTimer -= deltaTime;
		WeaponType weaponType = player.inventory.GetWeaponType();
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SPACE) && player.ShootingTimer <= 0) {
			player.ShootingTimer = weaponType.firingRate;
			Vector2 mousePosition = Input.GetMouseListener().GetPosition();
			mousePosition = Camera.GetCamera().CalculateScreenToWorld(mousePosition);

			Vector2 playerPos = State.world.player.Position.Add(new Vector2(0.5f,0.5f));
			Vector2 direction = new Vector2(mousePosition.x - playerPos.x, mousePosition.y - playerPos.y).Normalized();

			ProjectileEmitterUtil.CircleShot(playerPos, 40, weaponType, false);

			AudioPlayer.Play("shoot.wav");
		}
		if (isShooting && player.ShootingTimer <= 0) {
			player.ShootingTimer = weaponType.firingRate;
			Vector2 mousePosition = Input.GetMouseListener().GetPosition();
			mousePosition = Camera.GetCamera().CalculateScreenToWorld(mousePosition);

			Vector2 playerPos = State.world.player.Position.Add(new Vector2(0.5f,0.5f));
			Vector2 direction = new Vector2(mousePosition.x - playerPos.x, mousePosition.y - playerPos.y).Normalized();

			ProjectileEmitterUtil.Emit(player.inventory.GetWeaponType(), playerPos, direction);

			AudioPlayer.Play("shoot.wav");
		}
	}

	@Override
	public boolean OnClick(Vector2 screenLocation, int button, boolean isDown) {
		if (button == 0 && isDown) {
			isShooting = true;
		}
		if (button == 0 && isDown == false) {
			isShooting = false;
		}
		return false;
	}
}
