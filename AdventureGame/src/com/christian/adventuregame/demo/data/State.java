package com.christian.adventuregame.demo.data;

import com.christian.adventuregame.demo.data.terrain.Terrain;

public class State {
	public static World world;
	public static Terrain terrain;
	
	public static final int maxEnemiesToSpawn = 4;
	public static final float secondsBetweenEnemySpawn = 1.5f;
	public static float enemySpawnTimer = 0;
}
