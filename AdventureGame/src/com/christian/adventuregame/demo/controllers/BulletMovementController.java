package com.christian.adventuregame.demo.controllers;

import java.util.ArrayList;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.Bullet;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.utils.CollisionMovementUtil;
import com.christian.adventuregame.demo.utils.ProjectileMovementUtil;

public class BulletMovementController extends Controller {
	@Override
	public void Update(float deltaTime) {
		ArrayList<Bullet> bullets = State.world.bullets;
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);

			bullet.timer += deltaTime;
			Vector2 direction = ProjectileMovementUtil.Move(bullet).Mul(deltaTime);
			if (!CollisionMovementUtil.CanBeAt(new Box(bullet.Position.Add(direction), bullet.Size))) {
				bullets.remove(i);
				continue;
			}
			bullet.Position = bullet.Position.Add(direction);

			if (State.world.player.Position.Sub(bullet.Position).Magnitude() > 10) {
				bullets.remove(i);
			}
		}
	}
}
