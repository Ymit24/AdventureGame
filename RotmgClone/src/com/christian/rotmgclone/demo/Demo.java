package com.christian.rotmgclone.demo;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.demo.controllers.BulletMovementController;
import com.christian.rotmgclone.demo.controllers.BulletSpawnController;
import com.christian.rotmgclone.demo.controllers.CameraController;
import com.christian.rotmgclone.demo.controllers.DemoController;
import com.christian.rotmgclone.demo.data.Data;
import com.christian.rotmgclone.demo.data.Enemy;
import com.christian.rotmgclone.demo.data.World;
import com.christian.rotmgclone.demo.views.GameplayView;
import com.christian.rotmgclone.logic.ControllerManager;
import com.christian.rotmgclone.logic.GameLoop;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.core.CoreRenderer;

public class Demo {
	public static void main(String[] args) {
		new Demo();
	}
	
	public Demo() {
		Data.world = new World();
		World world = Data.world;
		world.GetEnemies().add(new Enemy(new Vector2(10, 10)));
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize();
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
