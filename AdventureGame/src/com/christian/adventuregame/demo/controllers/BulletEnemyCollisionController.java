package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.utils.Collision;
import com.christian.adventuregame.demo.data.Bullet;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.State;

public class BulletEnemyCollisionController extends Controller {
	@Override
	public void Update(float deltaTime) {
		for (int enemyIndex = 0; enemyIndex < State.world.enemies.size(); enemyIndex++) {
			Enemy enemy = State.world.enemies.get(enemyIndex);
			for (int bulletIndex = 0; bulletIndex < State.world.bullets.size(); bulletIndex++) {
				Bullet bullet = State.world.bullets.get(bulletIndex);
				if (Collision.AABB(enemy.Position, bullet.Position, enemy.Size, bullet.Size)) {
					State.world.bullets.remove(bullet);
					AudioPlayer.Play("hit.wav");
					enemy.health -= 1;
					
					if (enemy.health <= 0)
					{
						State.world.enemies.remove(enemy);
					}
				}
			}
		}
	}
}
