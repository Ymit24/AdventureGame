package com.christian.adventuregame.demo.controllers;

import java.util.ArrayList;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.Bullet;
import com.christian.adventuregame.demo.data.State;

public class BulletMovementController extends Controller {
	@Override
	public void Update(float deltaTime) {
		ArrayList<Bullet> bullets = State.world.bullets;
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			Vector2 position = bullet.Position;
			position = position.Add(bullet.GetDirection().Normalized().Mul(Bullet.SPEED*deltaTime));
			bullet.Position = position;
			
			if (State.world.player.Position.Sub(position).Magnitude() > 10) {
				bullets.remove(i);
			}
		}
	}
}
