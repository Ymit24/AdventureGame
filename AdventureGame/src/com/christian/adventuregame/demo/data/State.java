package com.christian.adventuregame.demo.data;

import java.util.ArrayList;

import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventuregame.demo.data.terrain.Terrain;

public class State {
	public static World world;
	public static Terrain terrain;
	
	public static final int maxEnemiesToSpawn = 12;
	public static final float secondsBetweenEnemySpawn = 1.5f;
	public static float enemySpawnTimer = 0;
	
	public static ArrayList<FloatTextEffect> floatTextEffects = new ArrayList<>();

	public static VerticalPushLayout mainUILayout;
}
