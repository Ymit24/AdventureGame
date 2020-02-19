package com.christian.adventureengine.demo;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.demo.controllers.BulletMovementController;
import com.christian.adventureengine.demo.controllers.BulletSpawnController;
import com.christian.adventureengine.demo.controllers.CameraController;
import com.christian.adventureengine.demo.controllers.DemoController;
import com.christian.adventureengine.demo.data.Data;
import com.christian.adventureengine.demo.data.Enemy;
import com.christian.adventureengine.demo.data.World;
import com.christian.adventureengine.demo.views.GameplayView;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;

public class Demo {
	public static void main(String[] args) {
		new Demo();
	}
	
	public Demo() {
		Data.world = new World();
		World world = Data.world;
		world.GetEnemies().add(new Enemy(new Vector2(10, 10)));
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Game");
		renderer.CreateInput();
		renderer.CreateSpriteManager();
		renderer.CreateCamera(new Vector2(20, 10));

		GameplayView view = new GameplayView();
		renderer.SetRootView(view);
		
		ControllerManager.AddController(new DemoController());
		ControllerManager.AddController(new CameraController());
		ControllerManager.AddController(new BulletSpawnController());
		ControllerManager.AddController(new BulletMovementController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
