package com.christian.adventuregame.demo;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.World;
import com.christian.adventuregame.demo.data.terrain.Terrain;
import com.christian.adventuregame.demo.utils.TileLoaderUtil;
import com.christian.adventuregame.demo.views.GameplayView;

public class Boot {
	public static void main(String[] args) {
		new Boot();
	}
	
	public Boot() {
		State.world = new World();
		World world = State.world;
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Game", 1280, 720);
		renderer.CreateInput();
		renderer.CreateSpriteManager();
		renderer.CreateCamera(new Vector2(20, 10), new Vector2(1000, 720));

		TileLoaderUtil.LoadTileTypes();
		
		GameplayView view = new GameplayView();
		renderer.SetRootView(view);
		
		State.terrain = new Terrain(30,30);

//		ControllerManager.AddController(new DemoController());
//		ControllerManager.AddController(new EnemySpawner());
//		ControllerManager.AddController(new EnemyWanderController());
//		ControllerManager.AddController(new EnemyMovement());
//		ControllerManager.AddController(new CameraController());
//		ControllerManager.AddController(new BulletSpawnController());
//		ControllerManager.AddController(new BulletMovementController());
//		ControllerManager.AddController(new BulletEnemyCollisionController());
//		ControllerManager.AddController(new MousePickerController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
