package com.christian.adventuregame.demo;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventuregame.demo.controllers.*;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.World;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.ui.GameUI;
import com.christian.adventuregame.demo.utils.loaders.*;
import com.christian.adventuregame.demo.utils.TerrainUtil;
import com.christian.adventuregame.demo.views.*;

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
		renderer.CreateCamera(new Vector2(16,10), new Box(0, 0, 1000, 720));

		TileLoaderUtil.LoadTileTypes();
		EnemyLoaderUtil.LoadEnemyTypes();
		WeaponLoaderUtil.LoadWeapons();
		RegionLoaderUtil.LoadRegions();
		TerrainFeatureLoader.Load();
		ItemLoader.Load();

		State.mainUILayout = renderer.CreateUILayout(new Box(1000, 150, 280, 570));
		new GameUI().Create();

		State.world.player.inventory.equippedWeaponItem = Archetypes.Items.Get("purple_wand_item");

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
