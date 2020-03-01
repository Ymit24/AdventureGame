package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.State;

public class EnemyMovement extends Controller {
	@Override
	public void Update(float deltaTime) {
		for (Enemy enemy : State.world.enemies) {
			if (enemy.isWandering == false)
				continue;
			
			Vector2 direction = enemy.wanderingTarget.Sub(enemy.Position).Normalized();
			enemy.Position = enemy.Position.Add(direction.Mul(Enemy.MOVE_SPEED * deltaTime));
		}
	}
}
