package com.christian.adventuregame.demo;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventureengine.ui.LayoutType;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.utils.ResourceManager;
import com.christian.adventuregame.demo.controllers.BulletEnemyCollisionController;
import com.christian.adventuregame.demo.controllers.BulletMovementController;
import com.christian.adventuregame.demo.controllers.BulletSpawnController;
import com.christian.adventuregame.demo.controllers.CameraController;
import com.christian.adventuregame.demo.controllers.EnemyFireController;
import com.christian.adventuregame.demo.controllers.EnemyMovement;
import com.christian.adventuregame.demo.controllers.EnemySpawner;
import com.christian.adventuregame.demo.controllers.EnemyWanderController;
import com.christian.adventuregame.demo.controllers.FloatTextEffectController;
import com.christian.adventuregame.demo.controllers.InventoryDragController;
import com.christian.adventuregame.demo.controllers.PlayerBulletCollisionController;
import com.christian.adventuregame.demo.controllers.PlayerMovementController;
import com.christian.adventuregame.demo.controllers.WeaponEquipSwitcher;
import com.christian.adventuregame.demo.controllers.ZoomController;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.World;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.ui.GameUI;
import com.christian.adventuregame.demo.utils.TerrainUtil;
import com.christian.adventuregame.demo.utils.loaders.EnemyLoaderUtil;
import com.christian.adventuregame.demo.utils.loaders.ItemLoader;
import com.christian.adventuregame.demo.utils.loaders.RegionLoaderUtil;
import com.christian.adventuregame.demo.utils.loaders.TerrainFeatureLoader;
import com.christian.adventuregame.demo.utils.loaders.TileLoaderUtil;
import com.christian.adventuregame.demo.utils.loaders.WeaponLoaderUtil;
import com.christian.adventuregame.demo.views.BulletView;
import com.christian.adventuregame.demo.views.EnemyView;
import com.christian.adventuregame.demo.views.FloatTextEffectView;
import com.christian.adventuregame.demo.views.GameplayView;
import com.christian.adventuregame.demo.views.InventoryView;
import com.christian.adventuregame.demo.views.PlayerStatsView;
import com.christian.adventuregame.demo.views.PlayerView;
import com.christian.adventuregame.demo.views.TerrainView;

public class GameBoot {
	public static void main(String[] args) {
		new GameBoot();
	}

	public GameBoot() {
		State.world = new World();

		boolean isFullScreen = false;
	
		/*  USE THE DEFAULT RESOURCE MANAGER  */
		ResourceManager.Initialize(new ResourceManager());
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Game", isFullScreen ? 1920 : 1280, isFullScreen ? 1080 : 720, isFullScreen);
		renderer.CreateInput();
		renderer.CreateSpriteManager();
		renderer.CreateCamera(new Vector2(16,10), new Box(0, 0, isFullScreen ? 1920-280 : 1000, isFullScreen ? 1080 : 720));

		TileLoaderUtil.LoadTileTypes();
		EnemyLoaderUtil.LoadEnemyTypes();
		WeaponLoaderUtil.LoadWeapons();
		RegionLoaderUtil.LoadRegions();
		TerrainFeatureLoader.Load();
		ItemLoader.Load();

		State.mainUILayout = (VerticalPushLayout) renderer.CreateFrame("_main_ui_", "_main_", new Box(isFullScreen ? 1920-280 : 1000, 150, 280, 570), LayoutType.VERTICAL_PUSH, false, false, false, 0).Layout;
		new GameUI().Create();

		State.world.player.inventory.storageItems[0] = Archetypes.Items.Get("purple_wand_item");

		State.terrain = TerrainUtil.LoadFromFile();

		renderer.AddView(new PlayerStatsView());
		renderer.AddView(new TerrainView());
		renderer.AddView(new EnemyView());
		renderer.AddView(new BulletView());
		renderer.AddView(new PlayerView());
		renderer.AddView(new FloatTextEffectView());
		renderer.AddView(new GameplayView());
		renderer.AddView(new InventoryView());

		AudioPlayer.Play("background.wav");

		new ZoomController();
		ControllerManager.AddController(new PlayerBulletCollisionController());
		ControllerManager.AddController(new EnemyFireController());
		ControllerManager.AddController(new WeaponEquipSwitcher());
		ControllerManager.AddController(new InventoryDragController());
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
