package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.RegionType;
import com.christian.adventuregame.demo.data.terrain.Terrain;

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

			Vector2 tileRingPosition = Camera.GetCamera().GetCameraBounds().RingTile(4);
			tileRingPosition = new Vector2((int)tileRingPosition.x, (int)tileRingPosition.y);

			Terrain terrain = State.terrain;
			while ( (int)tileRingPosition.x < 0 || (int)tileRingPosition.x >= terrain.width ||
					(int)tileRingPosition.y < 0 || (int)tileRingPosition.y >= terrain.height) {
				tileRingPosition = Camera.GetCamera().GetCameraBounds().RingTile(4);
				tileRingPosition = new Vector2((int)tileRingPosition.x, (int)tileRingPosition.y);
			}

			String regionId = terrain.tiles[(int)tileRingPosition.x][(int)tileRingPosition.y].regionId;
			RegionType type = Archetypes.Regions.Get(regionId);

			State.world.SpawnEnemy(tileRingPosition, type.enemyIds[Randomizer.random.nextInt(type.enemyIds.length)]);
		}
	}
}
