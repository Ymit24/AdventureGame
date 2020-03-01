package com.christian.adventuregame.demo.controllers;

import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

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
			
			Random random = Randomizer.random;
			float wanderRange = 5;
			
			// between(max (camera left, x - wanderRange), min(camera right, x + wanderRange))
			float wanderX = Randomizer.Between(
				Math.max(
					Camera.GetCamera().GetCameraBounds().GetLeft(),
					enemy.Position.x - wanderRange
				),
				Math.min(
					Camera.GetCamera().GetCameraBounds().GetRight(),
					enemy.Position.x + wanderRange
				)
			);
			
			enemy.wanderingTarget = new Vector2(wanderX, enemy.Position.y);
			enemy.isWandering = true;
			System.out.println("Enemy now wandering to: " + enemy.wanderingTarget);
		}
	}
}
