package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.utils.CollisionMovementUtil;

import java.util.MissingFormatWidthException;

public class EnemyMovement extends Controller {
	private static final float ENEMY_DESPAWN_RANGE = 18;
	@Override
	public void Update(float deltaTime) {
		for (int i = 0; i < State.world.enemies.size(); i++) {
			Enemy enemy = State.world.enemies.get(i);
			if (enemy.isWandering == false)
				continue;
			
			Vector2 direction = enemy.wanderingTarget.Sub(enemy.Position).Normalized().Mul(enemy.moveSpeed * deltaTime);
			if (!CollisionMovementUtil.CanBeAt(new Box(enemy.Position.Add(direction), enemy.Size))) {
				enemy.isWandering = false;
			}
			Vector2 newDirection = CollisionMovementUtil.TryMove(enemy, direction);

			enemy.Position = enemy.Position.Add(newDirection);

			if (State.world.player.Position.Sub(enemy.Position).Magnitude() > ENEMY_DESPAWN_RANGE)
			{
				State.world.enemies.remove(enemy);
				System.out.println("Despawning enemy.");
			}
		}
	}
}
