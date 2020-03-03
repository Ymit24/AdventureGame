package com.christian.adventuregame.demo;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventuregame.demo.controllers.BulletEnemyCollisionController;
import com.christian.adventuregame.demo.controllers.BulletMovementController;
import com.christian.adventuregame.demo.controllers.BulletSpawnController;
import com.christian.adventuregame.demo.controllers.CameraController;
import com.christian.adventuregame.demo.controllers.DemoController;
import com.christian.adventuregame.demo.controllers.EnemyMovement;
import com.christian.adventuregame.demo.controllers.EnemySpawner;
import com.christian.adventuregame.demo.controllers.EnemyWanderController;
import com.christian.adventuregame.demo.controllers.MousePickerController;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.World;
import com.christian.adventuregame.demo.utils.TerrainUtil;
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
		State.terrain = TerrainUtil.LoadFromFile();
		
		GameplayView view = new GameplayView();
		renderer.SetRootView(view);
		
		ControllerManager.AddController(new DemoController());
		ControllerManager.AddController(new EnemySpawner());
		ControllerManager.AddController(new EnemyWanderController());
		ControllerManager.AddController(new EnemyMovement());
		ControllerManager.AddController(new CameraController());
		ControllerManager.AddController(new BulletSpawnController());
		ControllerManager.AddController(new BulletMovementController());
		ControllerManager.AddController(new BulletEnemyCollisionController());
		ControllerManager.AddController(new MousePickerController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
