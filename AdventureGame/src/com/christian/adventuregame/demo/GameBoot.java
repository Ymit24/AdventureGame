package com.christian.adventuregame.demo;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventuregame.demo.controllers.BulletEnemyCollisionController;
import com.christian.adventuregame.demo.controllers.BulletMovementController;
import com.christian.adventuregame.demo.controllers.BulletSpawnController;
import com.christian.adventuregame.demo.controllers.CameraController;
import com.christian.adventuregame.demo.controllers.PlayerMovementController;
import com.christian.adventuregame.demo.controllers.EnemyMovement;
import com.christian.adventuregame.demo.controllers.EnemySpawner;
import com.christian.adventuregame.demo.controllers.EnemyWanderController;
import com.christian.adventuregame.demo.controllers.FloatTextEffectController;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.World;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.utils.loaders.EnemyLoaderUtil;
import com.christian.adventuregame.demo.utils.TerrainUtil;
import com.christian.adventuregame.demo.utils.loaders.RegionLoaderUtil;
import com.christian.adventuregame.demo.utils.loaders.TileLoaderUtil;
import com.christian.adventuregame.demo.utils.loaders.WeaponLoaderUtil;
import com.christian.adventuregame.demo.views.GameplayView;

public class GameBoot {
	public static void main(String[] args) {
		new GameBoot();
	}
	
	public GameBoot() {
		State.world = new World();
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Game", 1280, 720);
		renderer.CreateInput();
		renderer.CreateSpriteManager();
		renderer.CreateCamera(new Vector2(12,10), new Box(0, 0, 1000, 720));

		TileLoaderUtil.LoadTileTypes();
		EnemyLoaderUtil.LoadEnemyTypes();
		WeaponLoaderUtil.LoadWeapons();
		RegionLoaderUtil.LoadRegions();

		State.world.player.weaponType = Archetypes.Weapons.Get("simple_wand");

		State.terrain = TerrainUtil.LoadFromFile();
		
		GameplayView view = new GameplayView();
		renderer.SetRootView(view);

		AudioPlayer.Play("background.wav");
		
		ControllerManager.AddController(new PlayerMovementController());
		ControllerManager.AddController(new FloatTextEffectController());
		ControllerManager.AddController(new EnemySpawner());
		ControllerManager.AddController(new EnemyWanderController());
		ControllerManager.AddController(new EnemyMovement());
		ControllerManager.AddController(new CameraController());
		ControllerManager.AddController(new BulletSpawnController());
		ControllerManager.AddController(new BulletMovementController());
		ControllerManager.AddController(new BulletEnemyCollisionController());

		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
