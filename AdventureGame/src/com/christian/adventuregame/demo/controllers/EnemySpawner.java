package com.christian.adventuregame.demo.controllers;

import java.util.Random;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;

public class EnemySpawner extends Controller {
	@Override
	public void Update(float deltaTime) {
		State.enemySpawnTimer -= deltaTime;
		if (State.enemySpawnTimer <= 0)
		{
			State.enemySpawnTimer = State.secondsBetweenEnemySpawn;
			
			System.out.println("Enemy count: " + State.world.enemies.size());
			if (State.world.enemies.size() >= State.maxEnemiesToSpawn)
				return;
			
			// spawn enemy here if not over max
			Camera c = Camera.GetCamera();
			Box bounds = c.GetCameraBounds();
			
			Vector2 position = new Vector2(
				Randomizer.random.nextFloat() * (bounds.GetRight()-1),
				Randomizer.random.nextFloat() * (bounds.GetBottom()-1)
			);
			State.world.SpawnEnemy(position);
			
			System.out.println("Spawning enemy at: " + position);
		}
	}
}
