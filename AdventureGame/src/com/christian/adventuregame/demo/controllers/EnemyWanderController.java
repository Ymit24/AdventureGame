package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.utils.EnemyMovementAi;

public class EnemyWanderController extends Controller {
	private static final float WANDER_RANGE = 5;
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

			enemy.wanderingTarget = EnemyMovementAi.GetWanderTarget(enemy.Position, WANDER_RANGE);
			enemy.isWandering = true;
		}
	}
}
