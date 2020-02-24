package com.christian.adventuregame.demo.controllers;

import java.util.ArrayList;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.Bullet;
import com.christian.adventuregame.demo.data.Data;

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
