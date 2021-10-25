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
			State.enemySpawnTimer = State.secondsBetweenEnemySpawn; // TODO: Should probably be +=
			
			if (State.world.enemies.size() >= State.maxEnemiesToSpawn)
				return;
			
			Vector2 tileRingPosition = GetRingTilePosition();	
			RegionType regionType = GetRegionType(tileRingPosition);
			String enemyTypeId = GetRandomEnemyTypeId(regionType);

			System.out.println("region id : " + regionType.id + " enemies: ");
			State.world.SpawnEnemy(tileRingPosition, enemyTypeId);
		}
	}

	private RegionType GetRegionType(Vector2 location) {
		int tileX = (int)location.x;
		int tileY = (int)location.y;

		String regionId = State.terrain.tiles[tileX][tileY].regionId;
		RegionType type = Archetypes.Regions.Get(regionId);

		return type;
	}

	private String GetRandomEnemyTypeId(RegionType type) {
		return type.enemyIds[Randomizer.random.nextInt(type.enemyIds.length)];
	}

	private Vector2 GetRingTilePosition() {
		Camera c = Camera.GetCamera();
		Box bounds = c.GetCameraBounds();

		Vector2 tileRingPosition = Camera.GetCamera().GetCameraBounds().RingTile(2);
		tileRingPosition = new Vector2((int)tileRingPosition.x, (int)tileRingPosition.y);

		Terrain terrain = State.terrain;
		
		// TODO: IMPLEMENT CHECK TO MAKE SURE THIS NEVER CAUSES INFINITE LOOP.
		while (true) {
			while ((int) tileRingPosition.x < 0 || (int) tileRingPosition.x >= terrain.width ||
					(int) tileRingPosition.y < 0 || (int) tileRingPosition.y >= terrain.height) {
				tileRingPosition = Camera.GetCamera().GetCameraBounds().RingTile(2);
				tileRingPosition = new Vector2((int) tileRingPosition.x, (int) tileRingPosition.y);
			}
			if (terrain.tiles[(int)tileRingPosition.x][(int)tileRingPosition.y].isWalkable())
			{
				break;
			}
			else {
				tileRingPosition = Camera.GetCamera().GetCameraBounds().RingTile(6);
				tileRingPosition = new Vector2((int) tileRingPosition.x, (int) tileRingPosition.y);
			}
		}

		return tileRingPosition;
	}
}
