package com.christian.adventureeditor;

import java.io.IOException;

import com.christian.adventureeditor.controllers.CameraController;
import com.christian.adventureeditor.controllers.PaintController;
import com.christian.adventureeditor.ui.MainTools;
import com.christian.adventureeditor.views.EditorView;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventuregame.demo.utils.TerrainUtil;
import com.christian.adventuregame.demo.utils.loaders.RegionLoaderUtil;
import com.christian.adventuregame.demo.utils.loaders.TileLoaderUtil;

public class EditorBoot {
	public static void main(String[] args) throws IOException {
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Editor", 1280, 720);
		renderer.CreateInput();
		renderer.CreateCamera(new Vector2(14, 14), new Box(300, 0, 980, 720));
		renderer.CreateSpriteManager();
		
		TileLoaderUtil.LoadTileTypes();
		RegionLoaderUtil.LoadRegions();
		EditorData.layout = renderer.CreateUILayout(new Box(0, 30, 300, 720));
		new MainTools();
		
		renderer.SetRootView(new EditorView());

		EditorData.terrain = TerrainUtil.LoadFromFile();

		ControllerManager.AddController(new PaintController());
		ControllerManager.AddController(new CameraController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
