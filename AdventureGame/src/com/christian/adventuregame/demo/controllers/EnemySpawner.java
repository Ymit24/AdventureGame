package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;

public class EnemySpawner extends Controller {
	@Override
	public void Update(float deltaTime) {
		State.enemySpawnTimer -= deltaTime;
		if (State.enemySpawnTimer <= 0)
		{
			State.enemySpawnTimer = State.secondsBetweenEnemySpawn;
			
			if (State.world.enemies.size() >= State.maxEnemiesToSpawn)
				return;
			
			Camera c = Camera.GetCamera();
			Box bounds = c.GetCameraBounds();
			
			Vector2 position = new Vector2(
				Randomizer.random.nextFloat() * (bounds.GetRight()-1),
				Randomizer.random.nextFloat() * (bounds.GetBottom()-1)
			);
			State.world.SpawnEnemy(position, Archetypes.Enemies.GetRandomType().id);
		}
	}
}
