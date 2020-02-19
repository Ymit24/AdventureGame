package com.christian.adventureengine.demo.controllers;

import java.util.ArrayList;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.demo.data.Bullet;
import com.christian.adventureengine.demo.data.Data;
import com.christian.adventureengine.logic.Controller;

public class BulletMovementController extends Controller {
	@Override
	public void Update(float deltaTime) {
		ArrayList<Bullet> bullets = Data.world.GetBullets();
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			Vector2 position = bullet.GetPosition();
			position = position.Add(bullet.GetDirection().Normalized().Mul(Bullet.SPEED*deltaTime));
			bullet.SetPosition(position);
			
			if (Data.world.GetPlayer().GetPosition().Sub(position).Magnitude() > 10) {
				bullets.remove(i);
			}
		}
	}
}
