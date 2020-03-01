package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.State;

public class EnemyWanderController extends Controller {
	@Override
	public void Update(float deltaTime) {
		for (Enemy enemy : State.world.enemies) {
			if (enemy.isWandering) {
				if (enemy.wanderingTarget.Sub(enemy.Position).Magnitude() < 0.1) {
					enemy.isWandering = false;
				}
				else {
					continue;
				}
			}
			
			float wanderRange = 5;
			
			float wanderX = Randomizer.Between(
				Math.max(
					Camera.GetCamera().GetCameraBounds().GetLeft(),
					enemy.Position.x - wanderRange
				),
				Math.min(
					Camera.GetCamera().GetCameraBounds().GetRight() - 1,
					enemy.Position.x + wanderRange
				)
			);
			
			float wanderY = Randomizer.Between(
					Math.max(
						Camera.GetCamera().GetCameraBounds().GetTop(),
						enemy.Position.y - wanderRange
					),
					Math.min(
						Camera.GetCamera().GetCameraBounds().GetBottom() - 1,
						enemy.Position.y + wanderRange
					)
				);
			
			enemy.wanderingTarget = new Vector2(wanderX, wanderY);
			enemy.isWandering = true;
		}
	}
}
